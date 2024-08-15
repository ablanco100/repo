package com.challenge.tennis.application.services;

import java.util.List;
import java.util.Optional;

import com.challenge.tennis.domain.models.Tournament;
import com.challenge.tennis.domain.ports.in.TournamentUsesCase;

public class TournamentService implements TournamentUsesCase {

    private final TournamentUsesCase tournamentUsesCase;


    public TournamentService(TournamentUsesCase tournamentUsesCase) {
        this.tournamentUsesCase = tournamentUsesCase;
    }

    @Override
    public Optional<Tournament> getTournament(String id) {
        return tournamentUsesCase.getTournament(id);
    }

    @Override
    public List<Tournament> getTournaments() {
        return tournamentUsesCase.getTournaments();
    }
    
    @Override
    public List<Tournament> getTournamentsWinner(String name) {
        return tournamentUsesCase.getTournamentsWinner(name);
    }
    
    @Override
    public Tournament create(Tournament tournament) {
        return tournamentUsesCase.create(tournament);
    }
    
    @Override
    public boolean update(Tournament tournament) {
        return tournamentUsesCase.update(tournament);
    }
    
    @Override
    public boolean delete(String id) {
        return tournamentUsesCase.delete(id);
    }
    
    @Override
    public Tournament play(Tournament tournament) {
        return tournamentUsesCase.play(tournament);
    }
    
}
