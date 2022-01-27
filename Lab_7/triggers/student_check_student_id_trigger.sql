USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS student_check_student_id //
CREATE TRIGGER student_check_student_id
BEFORE INSERT 
ON student FOR EACH ROW
BEGIN 
	IF (new.`student_id` NOT REGEXP 'A[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][A-RT-Z]') THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Format error. student_id should consist of letter A, 8 digits and any letter except for S";
	END IF;
END //