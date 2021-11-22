package com.qa.hwaproject.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Club {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "club_name", nullable = false)
	private String clubName;
	
	@Column(name = "club_league", nullable = false)
	private String clubLeague;
	
	@Column(name = "club_location", nullable = false)
	private String clubLocation;
	
	@Column(name = "club_stadium", nullable = false)
	private String clubStadium;

	public Club(String clubName, String clubLeague, String clubLocation, String clubStadium) {
		super();
		this.clubName = clubName;
		this.clubLeague = clubLeague;
		this.clubLocation = clubLocation;
		this.clubStadium = clubStadium;
	}
	


}
