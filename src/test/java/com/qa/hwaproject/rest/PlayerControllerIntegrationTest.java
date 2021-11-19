package com.qa.hwaproject.rest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.hwaproject.persistence.domain.Club;
import com.qa.hwaproject.persistence.domain.Player;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")

@Sql(scripts = { "classpath:club-schema.sql", "classpath:club-data.sql", "classpath:player-schema.sql", "classpath:player-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class PlayerControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testAddPlayer() throws Exception {
		Club club = new Club(2, "manchester united", "premier league", "england", "old trafford");
		Player player = new Player("marcus rashford", 23, "england", "striker", 85, club);
		String playerAsJSON = this.mapper.writeValueAsString(player);
		RequestBuilder request = post("/player/create").contentType(MediaType.APPLICATION_JSON).content(playerAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Player playerSaved = new Player(2, "marcus rashford", 23, "england", "striker", 85, club);
		String playerSavedAsJSON = this.mapper.writeValueAsString(playerSaved);
		
		ResultMatcher checkBody = content().json(playerSavedAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		Club club = new Club(1, "real madrid", "la liga", "spain", "estadio santiago bernabeu");
		Player player = new Player(1, "cristiano ronaldo", 32, "portugal", "striker", 94, club);
		String playerJSON = this.mapper.writeValueAsString(List.of(player));
		RequestBuilder request = get("/player/getAll");
		
		ResultMatcher checkStatus = status().isOk();
		
		ResultMatcher checkBody = content().json(playerJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetById() throws Exception {
		
	}
	
	@Test
	void testUpdatePlayer() throws Exception {
		
	}
	
	@Test
	void testRemovePlayer() throws Exception {
		this.mvc.perform(delete("/player/delete/1")).andExpect(status().isNoContent());
	}
}
