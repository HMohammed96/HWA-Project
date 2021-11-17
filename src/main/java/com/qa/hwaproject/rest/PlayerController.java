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
	
	// READ
	@GetMapping("/getAll")
	public ResponseEntity<List<Player>> getAll() {
		return new ResponseEntity<List<Player>>(this.service.getAll(), HttpStatus.OK);
	}
	
	// READ BY ID
	@GetMapping("getById/{id}")
	public ResponseEntity<Player> getById(@PathVariable Long id) {
		return new ResponseEntity<Player>(this.service.getById(id), HttpStatus.OK);
	}
	
	// UPDATE
	@PutMapping("/update/{id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player player) {
		return new ResponseEntity<Player>(this.service.updatePlayer(id, player), HttpStatus.ACCEPTED);
	}
	
	// DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Player> removePlayer (@PathVariable Long id) {
		if (this.service.removePlayer(id)) {
			return new ResponseEntity<Player>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Player>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
