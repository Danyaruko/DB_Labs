USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS `before_class_delete` //
CREATE TRIGGER `before_class_delete`
BEFORE DELETE
ON `class` FOR EACH ROW
BEGIN 
	IF  old.`class_id` IN (SELECT `class_id` FROM student) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in student connected with this data, you can't delete it";
	END IF;
END //