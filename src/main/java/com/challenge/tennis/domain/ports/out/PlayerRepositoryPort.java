package com.challenge.tennis.domain.ports.out;

import com.challenge.tennis.domain.models.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerRepositoryPort {

    Optional<Player> findById(String id);
    List<Player> findAll();
    Player create(Player player);
    boolean delete(String id);
    boolean update(Player player);
}
