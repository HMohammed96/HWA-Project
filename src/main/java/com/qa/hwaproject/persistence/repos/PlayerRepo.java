package com.qa.hwaproject.persistence.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.hwaproject.persistence.domain.Player;

public interface PlayerRepo extends JpaRepository<Player, Long> {

}
