package com.qa.hwaproject.persistence.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qa.hwaproject.persistence.domain.Club;

public interface ClubRepo extends JpaRepository<Club, Long> {
	

	List<Club> findClubByClubLeague(String clubLeague);

	List<Club> findClubByClubLocation(String clubLocation);
}
