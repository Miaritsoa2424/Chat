package com.example.chat.service;

import com.example.chat.entities.Utilisateur;
import com.example.chat.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository repository;

    public List<Utilisateur> findAll() {
        return repository.findAll();
    }

    public Optional<Utilisateur> findById(Integer id) {
        return repository.findById(id);
    }

    public Utilisateur save(Utilisateur obj) {
        return repository.save(obj);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
