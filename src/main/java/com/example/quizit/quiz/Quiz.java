package com.example.quizit.quiz;

import com.example.quizit.player.Player;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "quiz")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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
    private String difficulty;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Quiz quiz = (Quiz) o;
        return id != null && Objects.equals(id, quiz.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
