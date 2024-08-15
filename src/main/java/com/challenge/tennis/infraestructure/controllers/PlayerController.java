package com.challenge.tennis.infraestructure.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.tennis.application.services.PlayerService;
import com.challenge.tennis.domain.models.Player;

@RestController
@RequestMapping(PlayerController.PLAYER_RESOURCES)
public class PlayerController {

    public static final String PLAYER_RESOURCES = "/api/v1/player";
    private final PlayerService playerService;
    
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
    	Player savedPlayer = playerService.create(player);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable String id) {
    	Player player = playerService.getPlayer(id).orElse(null);
        if (player == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(player);
    }
    
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Player>> getPlayers() {
    	List<Player> players = playerService.getPlayers();
        if (players.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(players);
    }
}
