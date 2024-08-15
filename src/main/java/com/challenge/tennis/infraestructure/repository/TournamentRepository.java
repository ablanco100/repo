package com.challenge.tennis.infraestructure.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.challenge.tennis.domain.models.Tournament;

public interface TournamentRepository  extends MongoRepository<Tournament, String> {

}
