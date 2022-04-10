package com.example.quizit.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "quiz")
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String question;
    @Column(name = "player_answer", nullable = false)
    private String playerAnswer;
    @Column(name = "correct_answer", nullable = false)
    private String correctAnswer;
    private String answer_a;
    private String answer_b;
    private String answer_c;
    private String answer_d;
    private String answer_e;
    private String answer_f;
    @Column(nullable = false)
    private String technology;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "player_id")
    private Player player;


}
