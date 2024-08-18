package com.challenge.tennis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.challenge.tennis.application.services.PlayerService;
import com.challenge.tennis.application.services.TournamentService;
import com.challenge.tennis.domain.models.Player;
import com.challenge.tennis.domain.models.Tournament;
import com.challenge.tennis.domain.models.Attribute;

@SpringBootTest
class TennisApplicationTests {

	private static Logger LOG = LoggerFactory.getLogger(TennisApplicationTests.class);	
	
	@Autowired 
	private PlayerService playerService;
	
	@Autowired 
	private TournamentService tournamentService;
	
	@Test
	void initBD() {

		LOG.info("Creando Torneos...");
		Tournament tournament = new Tournament();
		tournament.setId("1");
		tournament.setName("Wimbledon");
		tournament.setType("M");
		tournament.setNumberOfPlayers(4);
		tournament.setDate(new Date());
		tournament.setWinner("");
		tournamentService.create(tournament);
		
		LOG.info("Se finaliza la creacion de Torneos");
		
		LOG.info("Creando Jugadores...");
		Player player = new Player();
		player.setId("1");
		player.setName("Novak");
		player.setRanking(1);
		player.setBranch("M");
		List<Attribute> attributes = new ArrayList<>();
		attributes.add(new Attribute("ability", 90));
		attributes.add(new Attribute("force", 70));
		attributes.add(new Attribute("speed", 60));
		attributes.add(new Attribute("reaction", 70));
		player.setAttributes(attributes);
		playerService.create(player);
		
		player.setId("2");
		player.setName("Rafa");
		player.setRanking(2);
		player.setBranch("M");
		attributes = new ArrayList<>();
		attributes.add(new Attribute("ability", 80));
		attributes.add(new Attribute("force", 60));
		attributes.add(new Attribute("speed", 50));
		attributes.add(new Attribute("reaction", 70));
		player.setAttributes(attributes);
		playerService.create(player);
		
		player.setId("3");
		player.setName("Roger");
		player.setRanking(3);
		player.setBranch("M");
		attributes = new ArrayList<>();
		attributes.add(new Attribute("ability", 95));
		attributes.add(new Attribute("force", 75));
		attributes.add(new Attribute("speed", 70));
		attributes.add(new Attribute("reaction", 80));
		player.setAttributes(attributes);
		playerService.create(player);
		
		player.setId("4");
		player.setName("David");
		player.setRanking(4);
		player.setBranch("M");
		attributes = new ArrayList<>();
		attributes.add(new Attribute("ability", 85));
		attributes.add(new Attribute("force", 80));
		attributes.add(new Attribute("speed", 80));
		attributes.add(new Attribute("reaction", 70));
		player.setAttributes(attributes);
		playerService.create(player);
		
		LOG.info("Se finaliza la creacion de Jugadores");
		
		//LOG.info("Se borra el player con id 4");
		//playerService.delete("4");
	}
}
