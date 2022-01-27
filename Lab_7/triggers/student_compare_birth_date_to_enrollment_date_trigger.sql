USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS student_compare_birth_date_to_enrollment_date //
CREATE TRIGGER student_compare_birth_date_to_enrollment_date
BEFORE INSERT 
ON student FOR EACH ROW
BEGIN 
	IF TIMESTAMPDIFF(YEAR, new.`birth_date`, new.`enrollment_date`) < 16  THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "Invalid age. Student is too young to enroll, recheck the documents or contact me.";
	END IF;
END //