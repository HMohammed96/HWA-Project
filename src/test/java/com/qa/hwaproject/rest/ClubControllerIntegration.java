package com.qa.hwaproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@ActiveProfiles("test")

@Sql(scripts = { "classpath:club-schema.sql", "classpath:club-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class ClubControllerIntegration {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testAddClub() throws Exception {
		Club club = new Club("manchester united", "premier league", "england", "old trafford", 3600000000f);
		String clubAsJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = post("/club/create").contentType(MediaType.APPLICATION_JSON).content(clubAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Club clubSaved = new Club(1, "manchester united", "premier league", "england", "old trafford", 3600000000f);
		String clubSavedAsJSON = this.mapper.writeValueAsString(clubSaved);
		
		ResultMatcher checkBody = content().json(clubSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
}
