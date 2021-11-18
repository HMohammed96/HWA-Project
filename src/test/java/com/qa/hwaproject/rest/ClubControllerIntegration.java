package com.qa.hwaproject.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
		Club club = new Club("manchester united", "premier league", "england", "old trafford");
		String clubAsJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = post("/club/create").contentType(MediaType.APPLICATION_JSON).content(clubAsJSON);
		
		ResultMatcher checkStatus = status().isCreated();
		
		Club clubSaved = new Club(2, "manchester united", "premier league", "england", "old trafford");
		String clubSavedAsJSON = this.mapper.writeValueAsString(clubSaved);
		
		ResultMatcher checkBody = content().json(clubSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetAll() throws Exception {
		Club club = new Club(1, "real madrid", "la liga", "spain", "estadio santiago bernabeu");
		String clubJSON = this.mapper.writeValueAsString(List.of(club));
		RequestBuilder request = get("/club/getAll");
		
		ResultMatcher checkStatus =  status().isOk();
		
		ResultMatcher checkBody = content().json(clubJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testGetById() throws Exception {
		Club club = new Club(1, "real madrid", "la liga", "spain", "estadio santiago bernabeu");
		String clubJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = get("/club/getById/1");
		
		ResultMatcher checkStatus =  status().isOk();
		
		ResultMatcher checkBody = content().json(clubJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);	
	}
	
	@Test
	void testUpdateClub() throws Exception {
		Club club = new Club("atletico madrid", "la liga", "spain", "wanda metropolitano");
		String clubJSON = this.mapper.writeValueAsString(club);
		RequestBuilder request = put("/club/update/1").contentType(MediaType.APPLICATION_JSON).content(clubJSON);
		
		ResultMatcher checkStatus = status().isAccepted();
		
		Club clubSaved = new Club(1, "atletico madrid", "la liga", "spain", "wanda metropolitano");
		String clubSavedAsJSON = this.mapper.writeValueAsString(clubSaved);
		
		ResultMatcher checkBody = content().json(clubSavedAsJSON);
		
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testRemoveClub() throws Exception {
		this.mvc.perform(delete("/club/delete/1")).andExpect(status().isNoContent());
	}
}
