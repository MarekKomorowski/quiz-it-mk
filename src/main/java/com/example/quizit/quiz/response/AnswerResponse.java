package com.example.quizit.quiz.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class AnswerResponse {

    private String q0;
    private String q1;
    private String q2;
    private String q3;
    private String q4;
    private String q5;
    private String q6;
    private String q7;
    private String q8;
    private String q9;
    private Map<String, String> answers;

    public Map<String, String> getAnswers() {
        answers = new HashMap<>();
        answers.put("q0", q0);
        answers.put("q1", q1);
        answers.put("q2", q2);
        answers.put("q3", q3);
        answers.put("q4", q4);
        answers.put("q5", q5);
        answers.put("q6", q6);
        answers.put("q7", q7);
        answers.put("q8", q8);
        answers.put("q9", q9);

        return answers;
    }
}
