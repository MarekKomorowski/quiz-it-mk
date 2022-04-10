package com.example.quiz.controller;

import com.example.quiz.model.QuizDTO;
import com.example.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final QuizService quizService;

    @GetMapping(value = {"/", "/index"})
    public String getIndex(Model model){
        List<QuizDTO> quizDTO = quizService.getQuizDTO();
        model.addAttribute("players", quizDTO);
        return "index";
    }
}
