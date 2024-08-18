package com.challenge.tennis.application.usecases;

import com.challenge.tennis.domain.models.Player;
import com.challenge.tennis.domain.ports.in.PlayerUsesCase;
import com.challenge.tennis.domain.ports.out.PlayerRepositoryPort;


import java.util.List;
import java.util.Optional;

public class PlayerUsesCaseImpl implements PlayerUsesCase {
    
	private final PlayerRepositoryPort playerRepositoryPort;
    
    public PlayerUsesCaseImpl(PlayerRepositoryPort playerRepositoryPort) {
        this.playerRepositoryPort = playerRepositoryPort;
    }

    @Override
    public Optional<Player> getPlayer(String id) {
        return playerRepositoryPort.findById(id);
    }

    @Override
    public List<Player> getPlayers() {
        return playerRepositoryPort.findAll();
    }
    
    @Override
    public Player create(Player player) {
        return this.playerRepositoryPort.create(player);
    }
    
    @Override
    public boolean update(Player player) {
        return playerRepositoryPort.update(player);
    }
    
    @Override
    public boolean delete(String id) {
        return playerRepositoryPort.delete(id);
    }
}
