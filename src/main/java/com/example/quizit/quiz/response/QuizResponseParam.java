package com.example.quizit.quiz.response;

import lombok.Data;

@Data
public class QuizResponseParam {

    private String technology;
    private String difficulty;
    private Long playerId;
    private short numberOfQuestions;
}
