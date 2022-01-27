USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS `before_finished_secondary_school_delete` //
CREATE TRIGGER `before_finished_secondary_school_delete`
BEFORE DELETE
ON `finished_secondary_school` FOR EACH ROW
BEGIN 
	IF  old.`secondary_school_name` IN (SELECT `finished_secondary_school_name` FROM student) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in student connected with this data, you can't delete it";
	END IF;
END //