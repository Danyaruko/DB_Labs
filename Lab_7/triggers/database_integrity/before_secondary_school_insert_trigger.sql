USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS before_finished_secondary_school_input //
CREATE TRIGGER before_finished_secondary_school_input
BEFORE INSERT 
ON finished_secondary_school FOR EACH ROW
BEGIN 
	IF new.`location_city_name` NOT IN (SELECT `city_name` FROM `city`) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such location_city_name found in `city`.`city_name` 
        for secondary_school.`location_city_name`";
	END IF;
END //