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
}
