package com.qa.hwaproject.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "player_name", unique = true, nullable = false)
	private String playerName;
	
	@Column(name = "player_age", unique = true, nullable = false)
	private double playerAge;
	
	@Column(name = "player_nationality", unique = true, nullable = false)
	private String playerNationality;
	
	@Column(name = "player_position", unique = true, nullable = false)
	private String playerPosition;
	
	@Column(name = "player_overall_rating", unique = true, nullable = false)
	private double playerOverallRating;
	
	@Column(name = "player_value", unique = true, nullable = false)
	private float playerValue;
	
	@ManyToOne
	private Club club;

	public Player(String playerName, double playerAge, String playerNationality, String playerPosition,
			double playerOverallRating, float playerValue, Club club) {
		super();
		this.playerName = playerName;
		this.playerAge = playerAge;
		this.playerNationality = playerNationality;
		this.playerPosition = playerPosition;
		this.playerOverallRating = playerOverallRating;
		this.playerValue = playerValue;
		this.club = club;
	}

}
