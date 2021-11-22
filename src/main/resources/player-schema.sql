DROP TABLE IF EXISTS player CASCADE;

CREATE TABLE player (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
	player_name VARCHAR(255) NOT NULL,
	player_age BIGINT NOT NULL,
	player_nationality VARCHAR(255) NOT NULL,
	player_position VARCHAR(255) NOT NULL,
	player_overall_rating BIGINT NOT NULL,
	club_id BIGINT NOT NULL
);