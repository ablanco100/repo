package com.challenge.tennis.application.services;

import com.challenge.tennis.domain.models.Player;
import com.challenge.tennis.domain.ports.in.PlayerUsesCase;


import java.util.List;
import java.util.Optional;

public class PlayerService implements PlayerUsesCase {

    private final PlayerUsesCase playerUsesCase;


    public PlayerService(PlayerUsesCase playerUsesCase) {
        this.playerUsesCase = playerUsesCase;
    }

    @Override
    public Optional<Player> getPlayer(String id) {
        return playerUsesCase.getPlayer(id);
    }

    @Override
    public List<Player> getPlayers() {
        return playerUsesCase.getPlayers();
    }
    
    @Override
    public Player create(Player player) {
        return playerUsesCase.create(player);
    }
    
    @Override
    public boolean update(Player player) {
        return playerUsesCase.update(player);
    }
    
    @Override
    public boolean delete(String id) {
        return playerUsesCase.delete(id);
    }
    
}
