package com.challenge.tennis.infraestructure.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.challenge.tennis.domain.models.Tournament;
import com.challenge.tennis.domain.ports.out.TournamentRepositoryPort;

@Component
public class TournamentRepositoryAdapter implements TournamentRepositoryPort {

    private final TournamentRepository tournamentRepository;

    public TournamentRepositoryAdapter(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public Optional<Tournament> findById(String id) {
        return tournamentRepository.findById(id);
    }

    @Override
    public List<Tournament> findAll() {
        return tournamentRepository.findAll();
    }

    @Override
    public Tournament create(Tournament tournament) {
        return tournamentRepository.save(tournament);
        
    }
    
    @Override
	public boolean delete(String id) {
		if (tournamentRepository.existsById(id)) {
			tournamentRepository.deleteById(id);
            return true;
        }
        return false;
	}

    @Override
    public boolean update(Tournament tournament) {
        if (tournamentRepository.existsById(tournament.getId())){
        	tournamentRepository.save(tournament);
            return true;
        }
        return false;
    }

}
