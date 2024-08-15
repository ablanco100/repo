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

import com.challenge.tennis.application.services.TournamentService;
import com.challenge.tennis.domain.models.Tournament;

@RestController
@RequestMapping(TournamentController.TOURNAMENT_RESOURCES)
public class TournamentController {

    public static final String TOURNAMENT_RESOURCES = "/api/v1/tournament";
    private final TournamentService tournamentService;
    
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping(value = "/save")
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
    	Tournament savedTournament = tournamentService.create(tournament);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTournament);
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable String id) {
    	Tournament tournament = tournamentService.getTournament(id).orElse(null);
        if (tournament == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tournament);
    }
    
    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Tournament>> getTournaments() {
    	List<Tournament> tournaments = tournamentService.getTournaments();
        if (tournaments.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tournaments);
    }
    
    @PostMapping(value = "/play")
    public ResponseEntity<Tournament> playTournament(@RequestBody Tournament tournament) {
    	Tournament playedTournament = tournamentService.play(tournament);
        return ResponseEntity.status(HttpStatus.CREATED).body(playedTournament);
    }
    
    @GetMapping(value = "/find/winner/{name}")
    public ResponseEntity<List<Tournament>> getTournaments(@PathVariable String name) {
    	List<Tournament> tournaments = tournamentService.getTournamentsWinner(name);
        if (tournaments.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(tournaments);
    }
}
