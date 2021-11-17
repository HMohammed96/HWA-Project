package com.qa.hwaproject.persistence.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.hwaproject.persistence.domain.Club;

public interface ClubRepo extends JpaRepository<Club, Long> {
	
	@Query(value = "SELECT * FROM Club WHERE club_league = ?", nativeQuery = true)
	List<Club> findClubByLeague(String clubLeague);

	@Query(value = "SELECT * FROM Club WHERE club_location = ?", nativeQuery = true)
	List<Club> findClubByLocation(String clubLocation);

}
