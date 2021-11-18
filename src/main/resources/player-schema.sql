DROP TABLE IF EXISTS `player` CASCADE;

CREATE TABLE `player` (
	`player_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`club_id` BIGINT FOREIGN KEY,
	`player_name` VARCHAR(255) NOT NULL,
	`player_age` BIGINT NOT NULL,
	`player_nationality` VARCHAR(255) NOT NULL
	`player_position` VARCHAR(255) NOT NULL
	`player_overall_rating` BIGINT NOT NULL
	`player_value` FLOAT NOT NULL
);