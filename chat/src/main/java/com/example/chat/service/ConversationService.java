package com.example.chat.service;

import com.example.chat.dto.ConversationDTO;
import com.example.chat.entities.Conversation;
import com.example.chat.entities.Message;
import com.example.chat.entities.Utilisateur;
import com.example.chat.repository.ConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConversationService {
    @Autowired
    private ConversationRepository repository;
    @Autowired
    private UtilisateurService uservice;
    @Autowired
    private UtilService utilService;

    public List<Conversation> findAll() {
        return repository.findAll();
    }

    public Optional<Conversation> findById(Integer id) {
        return repository.findById(id);
    }

    public Conversation save(Conversation obj) {
        return repository.save(obj);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    public Message getLastMessage(Conversation conversation) {
        if (conversation.getMessages() == null || conversation.getMessages().isEmpty()) {
            return null;
        }
        return repository.findLastMessageByConversationId(conversation.getId_conversation());
    }

    public Long countUnreadMessages(Conversation conversation, Utilisateur user) {
        return repository.countUnreadMessagesByConversationIdAndNotUser(conversation.getId_conversation(),user.getId_user());
    }

    public List<ConversationDTO> getConversationsWithLastMessage(int userId) throws Exception {
        List<ConversationDTO> conversationDTOs = new ArrayList<>();
        try {
            Utilisateur user = uservice.findById(userId)
                .orElseThrow(() -> new Exception("User not found with ID: " + userId));
            List<Conversation> conversations = user.getConversations();

            for (Conversation conversation : conversations) {
                ConversationDTO dto = new ConversationDTO();
                dto.setConversation(conversation);
                Message lastMessage = getLastMessage(conversation);
                dto.setLastMessage(lastMessage);
                dto.setUtilisateur(user);
                if (lastMessage != null) {
                    dto.setSendAgo(utilService.getTimeAgo(lastMessage.getDate_envoi()));
                }
                conversationDTOs.add(dto);
            }
            return conversationDTOs;
        } catch (Exception e) {
            throw new Exception("Erreur de récupération des conversations : " + e.getMessage());
        }
    }

}
