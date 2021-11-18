package com.qa.hwaproject.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwaproject.persistence.domain.Club;
import com.qa.hwaproject.services.ClubService;

@RestController
@RequestMapping("/club")
public class ClubController {

	private ClubService service;

	public ClubController(ClubService service) {
		this.service = service;
	}

	// CREATE
	@PostMapping("/create")
	public ResponseEntity<Club> addClub(@RequestBody Club club) {
		return new ResponseEntity<Club>(this.service.addClub(club), HttpStatus.CREATED);
	}
	
	// READ
	@GetMapping("/getAll")
	public ResponseEntity<List<Club>> getAll() {
		return new ResponseEntity<List<Club>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// READ BY ID
	@GetMapping("getById/{id}")
	public ResponseEntity<Club> getById(@PathVariable Long id) {
		return new ResponseEntity<Club>(this.service.getById(id), HttpStatus.OK);
	}
	
	// FIND CLUB BY LEAGUE
	@GetMapping("/findClubByLeague/{clubLeague}")
	public ResponseEntity<List<Club>> findClubByLeague(String clubLeague) {
		return new ResponseEntity<List<Club>>(this.service.findClubByLeague(clubLeague), HttpStatus.OK);
	}
	
	// FIND CLUB BY LOCATION
	@GetMapping("/findClubByLocation/{clubLocation}")
	public ResponseEntity<List<Club>> findClubByLocation(String clubLocation) {
		return new ResponseEntity<List<Club>>(this.service.findClubByLocation(clubLocation), HttpStatus.OK);
	}
	
	// UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<Club> updateClub(@PathVariable Long id, @RequestBody Club club) {
		return new ResponseEntity<Club>(this.service.updateClub(id, club), HttpStatus.ACCEPTED);
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Club> removeClub (@PathVariable Long id) {
		if (this.service.removeClub(id)) {
			return new ResponseEntity<Club>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Club>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
