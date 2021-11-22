package com.qa.hwaproject.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
//@Data
@Getter
@Setter
@ToString
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
	
	@ManyToOne
	private Club club;

	public Player(String playerName, double playerAge, String playerNationality, String playerPosition,
			double playerOverallRating, Club club) {
		super();
		this.playerName = playerName;
		this.playerAge = playerAge;
		this.playerNationality = playerNationality;
		this.playerPosition = playerPosition;
		this.playerOverallRating = playerOverallRating;
		this.club = club;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (club == null) {
			if (other.club != null)
				return false;
		} else if (!club.equals(other.club))
			return false;
		if (Double.doubleToLongBits(playerAge) != Double.doubleToLongBits(other.playerAge))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (playerNationality == null) {
			if (other.playerNationality != null)
				return false;
		} else if (!playerNationality.equals(other.playerNationality))
			return false;
		if (Double.doubleToLongBits(playerOverallRating) != Double.doubleToLongBits(other.playerOverallRating))
			return false;
		if (playerPosition == null) {
			if (other.playerPosition != null)
				return false;
		} else if (!playerPosition.equals(other.playerPosition))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((club == null) ? 0 : club.hashCode());
		long temp;
		temp = Double.doubleToLongBits(playerAge);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + ((playerNationality == null) ? 0 : playerNationality.hashCode());
		temp = Double.doubleToLongBits(playerOverallRating);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((playerPosition == null) ? 0 : playerPosition.hashCode());
		return result;
	}
}
