package com.challenge.tennis.infraestructure.config;

import com.challenge.tennis.application.services.PlayerService;
import com.challenge.tennis.application.services.TournamentService;
import com.challenge.tennis.application.usecases.PlayerUsesCaseImpl;
import com.challenge.tennis.application.usecases.TournamentUsesCaseImpl;
import com.challenge.tennis.domain.ports.out.PlayerRepositoryPort;
import com.challenge.tennis.domain.ports.out.TournamentRepositoryPort;
import com.challenge.tennis.infraestructure.repository.PlayerRepositoryAdapter;
import com.challenge.tennis.infraestructure.repository.TournamentRepositoryAdapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public PlayerService playerService(PlayerRepositoryPort playerRepositoryPort){
        return new PlayerService( new PlayerUsesCaseImpl(playerRepositoryPort));
    }

    @Bean
    public PlayerRepositoryPort playerRepositoryPort(PlayerRepositoryAdapter playerRepositoryAdapter){
        return playerRepositoryAdapter;
    }

    @Bean
    public TournamentService tournamentService(TournamentRepositoryPort tournamentRepositoryPort, PlayerRepositoryPort playerRepositoryPort){
        return new TournamentService( new TournamentUsesCaseImpl(tournamentRepositoryPort,playerRepositoryPort));
    }

    @Bean
    public TournamentRepositoryPort tournamentRepositoryPort(TournamentRepositoryAdapter tournamentRepositoryAdapter){
        return tournamentRepositoryAdapter;
    }

}
