package com.challenge.tennis.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.challenge.tennis.domain.models.Tournament;

public interface TournamentUsesCase {
	
    Optional<Tournament> getTournament(String id);
    List<Tournament> getTournaments();
    List<Tournament> getTournamentsWinner(String name);
    Tournament create(Tournament tournament);
    boolean update(Tournament tournament);
    boolean delete(String id);
    Tournament play(Tournament tournament);
}
