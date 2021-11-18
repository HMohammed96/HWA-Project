package com.qa.hwaproject.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.hwaproject.persistence.domain.Club;
import com.qa.hwaproject.persistence.repos.ClubRepo;

@RunWith(MockitoJUnitRunner.class)
public class ClubServiceUnitTest {
	
	@InjectMocks
	private ClubService service;
	
	@Mock
	private ClubRepo repo;
	
	@Test
	public void addClubTest() {
		Club input = new Club("manchester united", "premier league", "england", "old trafford");
		Club output = new Club(2, "manchester united", "premier league", "england", "old trafford");
		
		Mockito.when(this.repo.saveAndFlush(input)).thenReturn(output);
		
		assertEquals(output, this.service.addClub(input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(input);
	}

	@Test
	public void getAllTest() {
		List<Club> output = new ArrayList<>();
		output.add(new Club("real madrid", "la liga", "spain", "estadio santiago bernabeu"));
		
		Mockito.when(this.repo.findAll()).thenReturn(output);
		
		assertEquals(output, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}

	@Test
	public void getByIdTest() {
		Club output =  new Club(1, "real madrid", "la liga", "spain", "estadio santiago bernabeu");
		
		Mockito.when(this.repo.findById(1L)).thenReturn(Optional.of(output));
		
		assertEquals(output, this.service.getById(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(1L);
	}
	
	@Test
	public void updateClubTest() {
		Optional<Club>existing = Optional.of(new Club(1L, "atletico madrid", "la liga", "spain", "wanda metropolitano"));
		Club input = new Club("real madrid", "la liga", "spain", "estadio santiago bernabeu");
		Club output = new Club(1L, "real madrid", "la liga", "spain", "estadio santiago bernabeu");
		
		Mockito.when(this.repo.findById(1L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(output)).thenReturn(output);
		
		assertEquals(output, this.service.updateClub(1L, input));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(output);
	}
	
	@Test
	public void removeClubTest() {
		boolean exists = true;
		
		Mockito.when(this.repo.existsById(1L)).thenReturn(exists);
		
		assertTrue(this.service.removeClub(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
}
