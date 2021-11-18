package com.qa.hwaproject.rest;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@Sql(scripts = { "classpath:club-schema.sql", "classpath:club-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class PlayerControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testAddPlayer() throws Exception {
		Club club = new Club("manchester united", "premier league", "england", "old trafford");
		Player player = new Player("marcus rashford", 23, "england", "striker", 85, club);
		String playerAsJSON = this.mapper.writeValueAsString(player);
		RequestBuilder request = post("/player/create").contentType(MediaType.APPLICATION_JSON).content(playerAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Player playerSaved = new Player(2, "marcus rashford", 23, "england", "striker", 85, club);
		String playerSavedAsJSON = this.mapper.writeValueAsString(playerSaved);
		
		ResultMatcher checkBody = content().json(playerSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
}
