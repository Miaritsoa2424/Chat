package com.example.chat.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.chat.entities.Conversation;
import com.example.chat.entities.Message;

@Repository
public interface ConversationRepository extends JpaRepository<Conversation,Integer>{
    
    @Query("SELECT m FROM Message m WHERE m.id_message = (SELECT MAX(m2.id_message) FROM Message m2 WHERE m2.conversation.id = :conversationId)")
    Message findLastMessageByConversationId(@Param("conversationId") Long conversationId);

    @Query("SELECT COUNT(m) FROM Message m WHERE m.conversation.id = :conversationId AND m.est_lu = false AND m.utilisateur.id != :userId")
    Long countUnreadMessagesByConversationIdAndNotUser(@Param("conversationId") Long conversationId, @Param("userId") Long userId);
    
}
