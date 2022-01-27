USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS `before_city_update` //
CREATE TRIGGER `before_city_update`
BEFORE UPDATE
ON `city` FOR EACH ROW
BEGIN 
	IF new.`oblast'_id` != old.`oblast'_id` THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Immutability error. Oblast'_id column cannot be updated. 
        If you believe information in this table to be outdated, please contact me.";
	END IF;
END //