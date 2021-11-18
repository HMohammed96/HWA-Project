DROP TABLE IF EXISTS `club` CASCADE;
CREATE TABLE `club`
(
	`club_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
	`club_name` VARCHAR(255) NOT NULL,
	`club_league` VARCHAR(255) NOT NULL,
	`club_location` VARCHAR(255) NOT NULL,
	`club_stadium` VARCHAR(255) NOT NULL,		
	`club_value` FLOAT NOT NULL
);