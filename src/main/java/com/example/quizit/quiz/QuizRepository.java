package com.example.quizit.quiz;

import com.example.quizit.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

    @Query("SELECT count(player.id) FROM quiz WHERE player.id = ?1 AND correctAnswer = playerAnswer")
    int countAllCorrectAnswersBy(Long id);

    @Query("SELECT count(player.id) FROM quiz WHERE player.id = ?1")
    int countAllAnswersBy(Long id);

    @Query(value = "FROM players")
    List<Player> findAllPlayers();

    @Query(value = "FROM players WHERE id = ?1")
    Player findPlayerById(Long id);
}

