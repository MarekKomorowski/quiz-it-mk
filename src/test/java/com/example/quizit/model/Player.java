package com.example.quiz.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "players")
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String name;
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

}
