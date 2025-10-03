package com.example.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat.entities.TypeConversation;

public interface TypeConversationRepository extends JpaRepository<TypeConversation,Integer>{
    
}
