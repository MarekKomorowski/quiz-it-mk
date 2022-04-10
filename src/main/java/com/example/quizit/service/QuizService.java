package com.example.quizit.service;

import com.example.quizit.model.Player;
import com.example.quizit.model.Quiz;
import com.example.quizit.model.QuizDTO;
import com.example.quizit.repository.QuizRepository;
import com.example.quizit.response.QuizResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class QuizService {

    private final ObjectMapper objectMapper;
    private final QuizRepository quizRepository;

    public HashMap<String, Quiz> getQuiz(String technology, String difficulty, Player player, short numberOfQuestions) {
        List<QuizResponse> quizResponses = new ArrayList<>();
        HttpClient httpClient = HttpClient.newHttpClient();
        String format = String.format("https://quizapi.io/api/v1/questions?apiKey=TVRhdZBe4SyNm2UU2l0axR4QBMidodl7rKNJO29H&category=%s&difficulty=%s&limit=%s", technology, difficulty, numberOfQuestions);
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(format))
                .build();
        try {
            HttpResponse<String> send = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            quizResponses = objectMapper.readValue(send.body(), new TypeReference<List<QuizResponse>>() {
            });
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        HashMap<String, Quiz> quizHashMap = mapResponseToQuiz(quizResponses);
        quizHashMap.forEach((s, quiz) -> quiz.setPlayer(player));
        quizHashMap.forEach((s, quiz) -> quiz.setTechnology(technology));

        return quizHashMap;

    }

    public List<QuizDTO> getQuizDTO() {
        List<QuizDTO> playersAndStats = new ArrayList<>();
        List<Player> allPlayers = quizRepository.findAllPlayers();
        for (Player player : allPlayers) {
            int allCorrectAnswers = quizRepository.countAllCorrectAnswersBy(player.getId());
            int allAnswers = quizRepository.countAllAnswersBy(player.getId());
            int percentOfCorrectAnswers = Math.round(100f * allCorrectAnswers / allAnswers);
            int allPlayerAnswers = quizRepository.countAllAnswersBy(player.getId());
            playersAndStats.add(new QuizDTO(player.getName(), player.getLastName(), percentOfCorrectAnswers, allPlayerAnswers));
        }
        playersAndStats = playersAndStats.stream()
                .sorted(Comparator.comparingDouble(QuizDTO::getPercentOfCorrectAnswers).reversed())
                .collect(Collectors.toList());
        return playersAndStats;
    }

    public List<Player> getAllPlayers() {
        return quizRepository.findAllPlayers();
    }

    public Player findPlayerById(Long id) {
        return quizRepository.findPlayerById(id);
    }

    private HashMap<String, Quiz> mapResponseToQuiz(List<QuizResponse> quizResponses) {
        HashMap<String, Quiz> quizMap = new HashMap<>();
        for (QuizResponse quizResponse : quizResponses) {
            Quiz quiz = new Quiz();
            quiz.setQuestion(quizResponse.getQuestion());
            quiz.setAnswer_a(quizResponse.getAnswers().getAnswer_a());
            quiz.setAnswer_b(quizResponse.getAnswers().getAnswer_b());
            quiz.setAnswer_c(quizResponse.getAnswers().getAnswer_c());
            quiz.setAnswer_d(quizResponse.getAnswers().getAnswer_d());
            quiz.setAnswer_e(quizResponse.getAnswers().getAnswer_e());
            quiz.setAnswer_f(quizResponse.getAnswers().getAnswer_f());
            quiz.setCorrectAnswer(mapCorrectAnswersToOneVariable(quizResponse));
            int indexOf = quizResponses.indexOf(quizResponse);
            String question = "q".concat(String.valueOf(indexOf));
            quizMap.put(question, quiz);
        }
        return quizMap;
    }

    public void saveQuizzes(Map<String, Quiz> quiz){
        Collection<Quiz> values = quiz.values();
        quizRepository.saveAll(values);
    }

    private String mapCorrectAnswersToOneVariable(QuizResponse quizResponse) {
        String correctAnswer = null;
        if (quizResponse.getCorrectAnswers().getAnswer_a()) {
            correctAnswer = quizResponse.getAnswers().getAnswer_a();
        }
        if (quizResponse.getCorrectAnswers().getAnswer_b()) {
            correctAnswer = quizResponse.getAnswers().getAnswer_b();
        }
        if (quizResponse.getCorrectAnswers().getAnswer_c()) {
            correctAnswer = quizResponse.getAnswers().getAnswer_c();
        }
        if (quizResponse.getCorrectAnswers().getAnswer_d()) {
            correctAnswer = quizResponse.getAnswers().getAnswer_d();
        }
        if (quizResponse.getCorrectAnswers().getAnswer_e()) {
            correctAnswer = quizResponse.getAnswers().getAnswer_e();
        }
        if (quizResponse.getCorrectAnswers().getAnswer_f()) {
            correctAnswer = quizResponse.getAnswers().getAnswer_f();
        }
        return correctAnswer;
    }

}