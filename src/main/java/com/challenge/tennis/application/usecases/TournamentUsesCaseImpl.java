package com.challenge.tennis.application.usecases;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.challenge.tennis.domain.models.Attribute;
import com.challenge.tennis.domain.models.Player;
import com.challenge.tennis.domain.models.Tournament;
import com.challenge.tennis.domain.ports.in.TournamentUsesCase;
import com.challenge.tennis.domain.ports.out.PlayerRepositoryPort;
import com.challenge.tennis.domain.ports.out.TournamentRepositoryPort;

public class TournamentUsesCaseImpl implements TournamentUsesCase {
    
	private final TournamentRepositoryPort tournamentRepositoryPort;
    private final PlayerRepositoryPort playerRepositoryPort;
           
    public TournamentUsesCaseImpl(TournamentRepositoryPort tournamentRepositoryPort, PlayerRepositoryPort playerRepositoryPort) {
        this.tournamentRepositoryPort = tournamentRepositoryPort;
		this.playerRepositoryPort = playerRepositoryPort;
    }

    @Override
    public Optional<Tournament> getTournament(String id) {
        return tournamentRepositoryPort.findById(id);
    }

    @Override
    public List<Tournament> getTournaments() {
        return tournamentRepositoryPort.findAll();
    }
    
    @Override
    public List<Tournament> getTournamentsWinner(String name) {
    	List<Tournament> tournaments = tournamentRepositoryPort.findAll();
    	tournaments = tournaments.stream().filter(x -> x.getWinner().equals(name)).sorted(Comparator.comparing(Tournament::getDate)).collect(Collectors.toList());
    	return tournaments;
    }
    
    @Override
    public Tournament create(Tournament tournament) {
        return this.tournamentRepositoryPort.create(tournament);
    }
    
    @Override
    public boolean update(Tournament tournament) {
        return tournamentRepositoryPort.update(tournament);
    }
    
    @Override
    public boolean delete(String id) {
        return tournamentRepositoryPort.delete(id);
    }
    
    @Override
    public Tournament play(Tournament tournament) {
    	List <Player> players = playerRepositoryPort.findAll();
    	players = players.stream().filter(x -> x.getBranch().equals(tournament.getType())).sorted(Comparator.comparing(Player::getRanking)).collect(Collectors.toList());
    	int numberOfPlayers = tournament.getNumberOfPlayers();
    	if (players.size() < numberOfPlayers || !isPow2(numberOfPlayers)) {
    		tournament.setWinner("No se pudo realizar el torneo por falta de jugadores/as o por no ser potencia de 2");
    	}else {
    		players = players.subList(0, tournament.getNumberOfPlayers());
	    	while (players.size() > 1) {
	    		int n = players.size()-1;
	    		List <Player> playersWin = new ArrayList<>();
		    	for(int i=0; i < n - i; i++) {
		        	Player p1 = players.get(i);
		        	Player p2 = players.get(n -i);
		        	Player pw = playGame(p1,p2);
		        	playersWin.add(pw);
		        }
		       	players = playersWin;
	    	}
	    	tournament.setWinner(players.get(0).getName()); 
	    	tournament.setDate(new Date());
    	}
    	tournamentRepositoryPort.update(tournament);
    	return tournament;
    }

	private Player playGame(Player p1, Player p2) {
		int scorep1, scorep2 = 0;
		if("M".equals(p1.getBranch())) {
			scorep1 = getAttribute(p1,"ability") + getAttribute(p1,"force") + getAttribute(p1,"speed");
		    scorep2 = getAttribute(p2,"ability") + getAttribute(p2,"force") + getAttribute(p2,"speed");
		}else {
			scorep1 = getAttribute(p1,"ability") + getAttribute(p1,"reaction");
			scorep2 = getAttribute(p2,"ability") + getAttribute(p2,"reaction");
		}
	    
	    // Agregar factor de suerte
	    double luckp1 = Math.random() * 100;
	    double luckp2 = Math.random() * 100;
	    
	    scorep1 += luckp1;
	    scorep2 += luckp2;
	    
	    if (scorep1 > scorep2) {
	      return p1;
	    } else {
	      return p2;
	    }
	}

	private int getAttribute(Player p1, String attr) {
		List<Attribute> listAttributesPlayer1 = p1.getAttributes();
		for (Iterator<Attribute> iterator = listAttributesPlayer1.iterator(); iterator.hasNext();) {
			Attribute attribute = (Attribute) iterator.next();
			if(attr.equals(attribute.getName())) {
				return attribute.getValue();
			}
		}
		return 0;
	}
	
	private boolean isPow2(int numberOfPlayers) {
		if(numberOfPlayers <= 0){
			return false;
		}
		return (numberOfPlayers & (numberOfPlayers - 1)) == 0;
	}

}
