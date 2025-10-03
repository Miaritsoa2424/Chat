package com.example.chat.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type_conversation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TypeConversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_type;

    @Column(nullable = false, length = 20)
    private String libelle;

    @OneToMany(mappedBy = "typeConversation")
    private List<Conversation> conversations = new ArrayList<>();
}
