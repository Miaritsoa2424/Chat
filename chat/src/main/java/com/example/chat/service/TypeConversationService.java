package com.example.chat.service;

import com.example.chat.entities.TypeConversation;
import com.example.chat.repository.TypeConversationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TypeConversationService {
    @Autowired
    private TypeConversationRepository repository;

    public List<TypeConversation> findAll() {
        return repository.findAll();
    }

    public Optional<TypeConversation> findById(Integer id) {
        return repository.findById(id);
    }

    public TypeConversation save(TypeConversation obj) {
        return repository.save(obj);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
