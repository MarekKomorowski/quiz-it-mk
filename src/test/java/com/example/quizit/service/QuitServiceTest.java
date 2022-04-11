package com.example.quizit.service;

import com.example.quizit.model.Player;
import com.example.quizit.model.Quiz;
import com.example.quizit.repository.QuizRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class QuitServiceTest {

    @Mock
    private QuizRepository quizRepository;
    
    @InjectMocks
    private QuizService quizService;


    @BeforeEach
    void setup(){
        //given
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        quizService = new QuizService(objectMapper, quizRepository);

    }
    @Test
    void getQuizTest(){
        //when
        HashMap<String, Quiz> quiz = quizService.getQuiz("sql", "medium", new Player(), (short) 5);
        //then
        assertThat(quiz).isNotNull();
        assertThat(quiz).isNotEmpty();
        assertThat(quiz).isInstanceOf(HashMap.class);
    }

}
