package com.challenge.tennis.application.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.challenge.tennis.domain.models.Attribute;
import com.challenge.tennis.domain.models.Player;
import com.challenge.tennis.domain.ports.in.PlayerUsesCase;

@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {
    @Mock
    PlayerUsesCase playerUsesCase;
    
    @InjectMocks
    PlayerService playerService;

    @Test
    void createPlayer(){
        Player player = new Player("1", "Roger", 1, "M", null);
        when(playerUsesCase.create(player)).thenReturn(new Player("1", "Roger", 1, "M", List.of(new Attribute("ability",85), new Attribute("force",80))));
        Player savePlayer = playerService.create(player);
        assertEquals("1",savePlayer.getId());
    }

    @Test
    void getPlayer(){
    	Player task = new Player("1", "Roger", 1, "M", List.of(new Attribute("ability",85), new Attribute("force",80)));
        when(playerUsesCase.getPlayer("1")).thenReturn(Optional.of(task));
        Player getPlayer = playerService.getPlayer("1").orElse(null);
        assertEquals("1",getPlayer.getId());
    }

    @Test
    void updatePlayerTask(){
    	Player player = new Player("1", "Roger", 1, "M", List.of(new Attribute("ability",85), new Attribute("force",80)));
        when(playerUsesCase.update(player)).thenReturn(true);
        boolean updatedPlayer = playerService.update(player);
        assertEquals(true,updatedPlayer);
    }

    @Test
    void deletePlayer(){
        doReturn(true).when(playerUsesCase).delete("1");
        boolean result = playerService.delete("1");
        assertEquals(true, result);
    }
}
