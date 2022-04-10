package com.example.quiz.service;

import com.example.quiz.model.Player;
import com.example.quiz.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    public Player save(Player player){
        return playerRepository.save(player);
    }

    public List<Player> findAllPlayers(){
        return playerRepository.findAll();
    }

    public Optional<Player> findPlayerById(Long id){
        return playerRepository.findById(id);
    }
}
