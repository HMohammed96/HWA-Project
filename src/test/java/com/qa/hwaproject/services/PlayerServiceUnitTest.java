package com.qa.hwaproject.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.hwaproject.persistence.domain.Club;
import com.qa.hwaproject.persistence.domain.Player;
import com.qa.hwaproject.persistence.repos.PlayerRepo;

@RunWith(MockitoJUnitRunner.class)
public class PlayerServiceUnitTest {

	@InjectMocks
	private PlayerService service;
	
	@Mock
	private PlayerRepo repo;
	
	private Club testClub = new Club ("manchester united", "premier league", "england", "old trafford");
	private Player testPlayer = new Player(2, "marcus rashford", 23, "england", "striker", 85, testClub);
	
	@Test
	public void addPlayerTest() {
		Mockito.when(this.repo.saveAndFlush(testPlayer)).thenReturn(testPlayer);
		
		assertEquals(testPlayer, this.service.addPlayer(testPlayer));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(testPlayer);
	}
	
	@Test
	public void getAllTest() {
		List<Player> testPlayer = new ArrayList<>();
		testPlayer.add(new Player("jadon sancho", 21, "england", "winger", 87, testClub));
	
		Mockito.when(this.repo.findAll()).thenReturn(testPlayer);
		
		assertEquals(testPlayer, this.service.getAll());
		
		Mockito.verify(this.repo, Mockito.times(1)).findAll();
	}
	
	@Test
	public void getByIdTest() {
		Player testPlayer = new Player(2L, "marcus rashford", 23, "england", "striker", 85, testClub);
		
		Mockito.when(this.repo.findById(2L)).thenReturn(Optional.of(testPlayer));
		
		assertEquals(testPlayer, this.service.getById(2L));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(2L);
	}
	
	@Test
	public void updatePlayerTest() {
		Optional<Player>existing = Optional.of(new Player(2, "marcus rashford", 23, "england", "winger", 85, testClub));
		Player testPlayer =  new Player("marcus rashford", 23, "england", "striker", 85, testClub);
		Player testPlayer2 = new Player(2L, "marcus rashford", 23, "england", "striker", 85, testClub);
	
		Mockito.when(this.repo.findById(2L)).thenReturn(existing);
		Mockito.when(this.repo.saveAndFlush(testPlayer2)).thenReturn(testPlayer2);
		
		assertEquals(testPlayer2, this.service.updatePlayer(2L, testPlayer));
		
		Mockito.verify(this.repo, Mockito.times(1)).saveAndFlush(testPlayer2);
	}
	
	@Test
	public void removePlayerTest() {
		this.service.addPlayer(testPlayer);
		boolean exists = true;
		
		Mockito.when(this.repo.existsById(2L)).thenReturn(false);
		assertTrue(this.service.removePlayer(2L));
		
		Mockito.verify(this.repo, Mockito.times(1)).existsById(2L);
	}

}
