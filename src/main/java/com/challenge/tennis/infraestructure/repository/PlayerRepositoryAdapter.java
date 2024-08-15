package com.challenge.tennis.infraestructure.repository;

import com.challenge.tennis.domain.models.Player;
import com.challenge.tennis.domain.ports.out.PlayerRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerRepositoryAdapter implements PlayerRepositoryPort {

    private final PlayerRepository playerRepository;

    public PlayerRepositoryAdapter(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Optional<Player> findById(String id) {
        return playerRepository.findById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player create(Player player) {
        return playerRepository.save(player);
        
    }
    
    @Override
	public boolean delete(String id) {
		if (playerRepository.existsById(id)) {
            playerRepository.deleteById(id);
            return true;
        }
        return false;
	}

    @Override
    public boolean update(Player player) {
        if (playerRepository.existsById(player.getId())){
            playerRepository.save(player);
            return true;
        }
        return false;
    }

	

}
