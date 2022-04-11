package com.example.quizit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "quiz")
@Data
@NoArgsConstructor
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private String technology;

    @OneToOne
    @JoinColumn(name = "player_id")
    private Player player;


}
