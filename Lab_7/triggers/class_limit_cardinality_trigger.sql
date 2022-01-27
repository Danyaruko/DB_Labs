USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS class_limit_cardinality //
CREATE TRIGGER class_limit_cardinality
BEFORE INSERT 
ON `class` FOR EACH ROW
BEGIN 
	IF (SELECT COUNT(`class`.class_id) FROM `class`) = 6  THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Invalid cardinality. There can not be more than 6 different classes.";
	END IF;
END //