package com.qa.hwaproject.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.hwaproject.persistence.domain.Player;

@RestController
@RequestMapping("/player")
public class PlayerController {
	
	private PlayerService service;
	
	public PlayerController(PlayerService service) {
		this.service = service;
	}
	
	// CREATE
	@PostMapping("/create")
	public ResponseEntity<Player> addPlayer(@RequestBody Player player) {
		return new ResponseEntity<Player>(this.service.addPlayer(player), HttpStatus.CREATED);
	}

}
