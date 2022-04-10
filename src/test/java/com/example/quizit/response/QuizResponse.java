package com.example.quiz.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class QuizResponse {


    private String question;
    @JsonProperty("correct_answer")
    private String correctAnswer;
    private Answers answers;
    @JsonProperty("correct_answers")
    private CorrectAnswers correctAnswers;

    @Data
    public static class Answers {

        String answer_a;
        String answer_b;
        String answer_c;
        String answer_d;
        String answer_e;
        String answer_f;
    }

    @Data
    public static class CorrectAnswers {

        @JsonProperty("answer_a_correct")
        Boolean answer_a;
        @JsonProperty("answer_b_correct")
        Boolean answer_b;
        @JsonProperty("answer_c_correct")
        Boolean answer_c;
        @JsonProperty("answer_d_correct")
        Boolean answer_d;
        @JsonProperty("answer_e_correct")
        Boolean answer_e;
        @JsonProperty("answer_f_correct")
        Boolean answer_f;
    }

}
