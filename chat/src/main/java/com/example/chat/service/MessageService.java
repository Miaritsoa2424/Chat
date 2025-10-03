package com.example.chat.service;

import com.example.chat.entities.Message;
import com.example.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository repository;

    public List<Message> findAll() {
        return repository.findAll();
    }

    public Optional<Message> findById(Integer id) {
        return repository.findById(id);
    }

    public Message save(Message obj) {
        return repository.save(obj);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
