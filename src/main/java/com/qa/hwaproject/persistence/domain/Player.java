package com.qa.hwaproject.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "player_name", unique = true, nullable = false)
	private long playerName;
	
	@Column(name = "player_age", unique = true, nullable = false)
	private double playerAge;
	
	@Column(name = "club_id", unique = true, nullable = false)
	private long clubId;
	
	@Column(name = "player_nationality", unique = true, nullable = false)
	private String playerNationality;
	
	@Column(name = "player_position", unique = true, nullable = false)
	private String playerPosition;
	
	@Column(name = "player_overall_rating", unique = true, nullable = false)
	private double playerOverallRating;
	
	@Column(name = "player_value", unique = true, nullable = false)
	private float playerValue;
	
	
}
