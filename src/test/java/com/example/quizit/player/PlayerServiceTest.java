package com.example.quizit.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@SpringBootTest
public class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;
    @InjectMocks
    private PlayerService playerService;
    private Player player;

    @BeforeEach
    void setup(){
        //given
        player = new Player();
        player.setName("John");
        player.setLastName("Smith");
        when(playerService.save(any(Player.class))).thenReturn(player);
    }

    @Test
    void savePLayerTest(){
        //when
        playerService.save(player);
        //then
        Assertions.assertNotNull(player);
        Assertions.assertEquals("John", player.getName());
        Assertions.assertEquals("Smith", player.getLastName());
    }

}
