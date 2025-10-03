package com.example.chat.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "conversation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_conversation;

    @Column(length = 50)
    private String nom;

    @Column(nullable = false)
    private LocalDateTime date_creation = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "id_type", nullable = false)
    private TypeConversation typeConversation;

    @OneToMany(mappedBy = "conversation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    @ManyToMany(mappedBy = "conversations")
    private List<Utilisateur> utilisateurs = new ArrayList<>();
}
