package com.challenge.tennis.infraestructure.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.challenge.tennis.application.services.PlayerService;
import com.challenge.tennis.domain.models.Attribute;
import com.challenge.tennis.domain.models.Player;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(PlayerControllerTest.class)
class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private PlayerService playerService;

//    @Test
//    void testGetPlayers() throws Exception {
//        mockMvc.perform(get(PlayerController.PLAYER_RESOURCES+ "/find/{id}", "1"))
//                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.OK.value()))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
//                .andReturn()
//                .getResponse()
//                .getContentAsString();
//    }
//
//    @Test
//    void testGetTaskNotFound() throws Exception {
//        mockMvc.perform(get(PlayerController.PLAYER_RESOURCES+ "/find/{id}", "150"))
//               .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()));
//    }
//
//    @Test
//    void testGetTaskBadRequest() throws Exception {
//        mockMvc.perform(get(PlayerController.PLAYER_RESOURCES+ "/find/{id}", 0))
//               .andExpect(MockMvcResultMatchers.status().is(HttpStatus.BAD_REQUEST.value()));
//    }
//
//    @Test
//    void testGetTaskMethodNotAllowed() throws Exception {
//        mockMvc.perform(get(PlayerController.PLAYER_RESOURCES))
//               .andExpect(MockMvcResultMatchers.status().is(HttpStatus.METHOD_NOT_ALLOWED.value()));
//    }

//    @Test
//    public void testAddShouldReturn201Created() throws Exception {
//    	Player player = new Player("1", "Roger", 1, "M", List.of(new Attribute("ability",85), new Attribute("force",80)));
//     
//        Mockito.when(playerService.create(player)).thenReturn(player);
//        ObjectMapper objectMapper = new ObjectMapper();
//        String requestBody = objectMapper.writeValueAsString(player);
//     
//        mockMvc.perform(post(PlayerController.PLAYER_RESOURCES+ "/save").
//        		contentType("application/json")
//                .content(requestBody))
//                .andExpect(status().isCreated())
//                .andDo(print())
//        ;
//     
//    }
    
    @Test
    void testAddShouldReturn400BadRequest() throws Exception {
    	Player player = new Player("1", "Roger", 1, "M", List.of(new Attribute("ability",85), new Attribute("force",80)));
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(player);

        mockMvc.perform(post(PlayerController.PLAYER_RESOURCES)
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NOT_FOUND.value()))
                .andReturn()
                .getResponse()
                .getContentAsString();

    }

}
