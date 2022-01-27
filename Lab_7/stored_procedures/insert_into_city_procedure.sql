USE Patana_7_64;

DELIMITER //
DROP PROCEDURE IF EXISTS `insert_into_city` //
CREATE PROCEDURE `insert_into_city` (
    IN city_name VARCHAR(45),
	IN `oblast'_id` VARCHAR(2)
    )
BEGIN
	INSERT INTO `city`(city_name, `oblast'_id`) 
    VALUES(city_name, `oblast'_id`);
END //