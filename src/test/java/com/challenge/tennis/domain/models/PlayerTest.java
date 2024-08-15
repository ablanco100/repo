package com.challenge.tennis.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class PlayerTest {

    @Test
    void testPlayerCreation() {
    	Player player = new Player("1", "Roger", 1, "M", List.of(new Attribute("ability",85), new Attribute("force",80)));
        assertEquals("1",player.getId());
        assertEquals("Roger",player.getName());
    }

    @Test
    void testPlayerUpdating() {
    	Player player = new Player("1", "Roger", 1, "M", List.of(new Attribute("ability",85), new Attribute("force",80)));
    	player.setName("Novak");
        assertEquals("Novak", player.getName());
    }
}
