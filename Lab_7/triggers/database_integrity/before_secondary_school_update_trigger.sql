USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS `before_finished_secondary_school_update` //
CREATE TRIGGER `before_finished_secondary_school_update`
BEFORE UPDATE
ON `finished_secondary_school` FOR EACH ROW
BEGIN 
	IF new.`location_city_name` != old.`location_city_name` THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Immutability error. Location_city_name column cannot be updated. 
        If you believe information in this table to be outdated, please contact me.";
	END IF;
END //