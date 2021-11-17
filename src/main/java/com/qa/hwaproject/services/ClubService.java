package com.qa.hwaproject.services;

import org.springframework.stereotype.Service;

import com.qa.hwaproject.persistence.domain.Club;

@Service
public class ClubService {
	
	private ClubRepo repo;
	
	public ClubService(ClubRepo repo) {
		this.repo = repo;
	}
	
	public Club addClub(Club club) {
		return this.repo.saveAndFlush(club);
	}
	
	public List<Club> getAll() {
		return this.repo.findAll();
	}
	
	public Club getById(Long id) {
		return this.repo.findById(id).orElseThrow(ClubNotFoundException::new);
	}
	
	public Club updateClub(Long id, Club club) {
		Club existing = this.repo.findById(id).get();
		
		existing.setClubName(club.getClubName());
		existing.setClubLeague(club.getClubLeague());
		existing.setClubLocation(club.getClubLocation());
		existing.setClubStadium(club.getClubStadium());
		existing.setClubValue(club.getClubValue());
		
		return this.repo.saveAndFlush(existing);
	}
	
	public boolean removeClub (Long id) {
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public List<Club> findClubByLeague(String clubLeague) {
		return this.repo.findClubByLeague(clubLeague);
	}
	
	public List<Club> findClubByLocation(String clubLocation) {
		return this.repo.findClubByLocation(clubLocation);
	}

}
