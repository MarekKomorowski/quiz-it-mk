package com.example.quizit.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizDTO {

    private String name;
    private String lastName;
    private int percentOfCorrectAnswers;
    private int allPlayerAnswers;
}
