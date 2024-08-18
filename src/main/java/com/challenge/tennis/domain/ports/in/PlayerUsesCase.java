package com.challenge.tennis.domain.ports.in;

import com.challenge.tennis.domain.models.Player;


import java.util.List;
import java.util.Optional;

public interface PlayerUsesCase {
	
    Optional<Player> getPlayer(String id);
    List<Player> getPlayers();
    Player create(Player player);
    boolean update(Player player);
    boolean delete(String id); 
}
