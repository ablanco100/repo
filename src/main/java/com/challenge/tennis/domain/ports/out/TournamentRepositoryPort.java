package com.challenge.tennis.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.challenge.tennis.domain.models.Tournament;

public interface TournamentRepositoryPort {

    Optional<Tournament> findById(String id);
    List<Tournament> findAll();
    Tournament create(Tournament tournament);
    boolean delete(String id);
    boolean update(Tournament tournament);
}
