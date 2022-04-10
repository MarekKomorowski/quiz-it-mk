package com.example.quizit.controller;

import com.example.quizit.model.Player;
import com.example.quizit.model.Quiz;
import com.example.quizit.response.AnswerResponse;
import com.example.quizit.response.QuizResponseParam;
import com.example.quizit.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@Controller
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;
    private HashMap<String, Quiz> quiz;


    @PostMapping("/quiz")
    public String getQuestion(Model model, @ModelAttribute QuizResponseParam quizResponseParam) {
        Player player = quizService.findPlayerById(quizResponseParam.getPlayerId());
        quiz = quizService.getQuiz(quizResponseParam.getTechnology(), quizResponseParam.getDifficulty(), player, quizResponseParam.getNumberOfQuestions());
        model.addAttribute("player", player);
        model.addAttribute("difficulty", quizResponseParam.getDifficulty());
        model.addAttribute("technology", quizResponseParam.getTechnology());
        model.addAttribute("map", quiz);
        return "quiz";
    }

    @PostMapping("/result")
    public String getQuestion(Model model, @ModelAttribute() AnswerResponse answerResponse) {
        for(String key:quiz.keySet()){
            quiz.get(key).setPlayerAnswer(answerResponse.getAnswers().get(key));
        }
        quizService.saveQuizzes(quiz);
        model.addAttribute("quiz", quiz);
        return "result";
    }

    @GetMapping("/chooseQuiz")
    public String chooseQuiz(Model model) {
        List<Player> allPlayers = quizService.getAllPlayers();
        model.addAttribute("players", allPlayers);
        return "chooseQuiz";

    }
}