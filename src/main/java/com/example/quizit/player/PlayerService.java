package com.example.quizit.player;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    Player save(Player player){
        return playerRepository.save(player);
    }

    List<Player> findAllPlayers(){
        return playerRepository.findAll();
    }

    Optional<Player> findPlayerById(Long id){
        return playerRepository.findById(id);
    }

    void deletePlayerById(Long id){
        playerRepository.deleteById(id);
    }
}
