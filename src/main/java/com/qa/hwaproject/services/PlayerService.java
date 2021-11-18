package com.qa.hwaproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.hwaproject.exceptions.PlayerNotFoundException;
import com.qa.hwaproject.persistence.domain.Player;
import com.qa.hwaproject.persistence.repos.PlayerRepo;

@Service
public class PlayerService {
	
	private PlayerRepo repo;
	
	public PlayerService(PlayerRepo repo) {
		this.repo = repo;
	}
	
	public Player addPlayer(Player player) {
		return this.repo.saveAndFlush(player);
	}
	
	public List<Player> getAll() {
		return this.repo.findAll();
	}
	
	public Player getById(Long id) {
		return this.repo.findById(id).orElseThrow(PlayerNotFoundException::new);
	}
	
	public Player updatePlayer(Long id, Player player) {
		Player existing = this.repo.findById(id).get();
		
		existing.setPlayerName(player.getPlayerName());
		existing.setPlayerAge(player.getPlayerAge());
		existing.setPlayerNationality(player.getPlayerNationality());
		existing.setPlayerPosition(player.getPlayerPosition());
		existing.setPlayerOverallRating(player.getPlayerOverallRating());
		existing.setClub(player.getClub());
		
		return this.repo.saveAndFlush(existing);
	}
	
	public boolean removePlayer (Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}

}
