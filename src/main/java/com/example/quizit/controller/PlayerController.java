package com.example.quizit.controller;

import com.example.quizit.model.Player;
import com.example.quizit.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping(value = {"/addPlayer"})
    public String viewAddPLayer(){
        return "/player/addPlayer";
    }

    @PostMapping({"/addPlayer"})
    public RedirectView addPLayer(@ModelAttribute Player player){
        playerService.save(player);
        return new RedirectView("/players");
    }

    @GetMapping({"/players"})
    public String viewPLayers(Model model){
        List<Player> allPlayers = playerService.findAllPlayers();
        model.addAttribute("players", allPlayers);
        return ("player/players");
    }

    @GetMapping({"/editPlayer/{id}"})
    public String viewPLayers(Model model, @PathVariable("id") Long id){
        Optional<Player> playerById = playerService.findPlayerById(id);
        model.addAttribute("player", playerById.get());
        return ("player/editPlayer");
    }

    @PostMapping({"/editPlayer/{id}"})
    public RedirectView addEditPLayer(@ModelAttribute Player player, @PathVariable Long id){
        player.setId(id);
        playerService.save(player);
        return new RedirectView("/players");
    }

}
