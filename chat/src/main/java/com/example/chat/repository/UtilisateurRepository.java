package com.example.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.chat.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer>{
    
}
