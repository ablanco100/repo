package com.challenge.tennis.infraestructure.repository;

import com.challenge.tennis.domain.models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository  extends MongoRepository<Player, String> {

}
