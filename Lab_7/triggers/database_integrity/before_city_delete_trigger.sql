USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS `before_city_delete` //
CREATE TRIGGER `before_city_delete`
BEFORE DELETE
ON `city` FOR EACH ROW
BEGIN 
	IF  old.`city_name` IN (SELECT `city_of_residence_name` FROM student) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in student connected with this data, you can't delete it";
	END IF;
    IF  old.`city_name` IN (SELECT `location_city_name` FROM secondary_school) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in secondary_school connected with this data, you can't delete it";
	END IF;
END //