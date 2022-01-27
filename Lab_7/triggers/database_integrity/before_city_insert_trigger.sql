USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS before_city_input //
CREATE TRIGGER before_city_input
BEFORE INSERT 
ON city FOR EACH ROW
BEGIN 
	IF new.`oblast'_id` NOT IN (SELECT `oblast'_id` FROM `oblast'`) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such oblast'_id found in `oblast'`.`oblast'_id` for city.`oblast'_id`";
	END IF;
END //