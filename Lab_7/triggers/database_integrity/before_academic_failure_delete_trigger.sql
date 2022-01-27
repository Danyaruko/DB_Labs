USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS before_academic_failure_delete //
CREATE TRIGGER before_academic_failure_delete
BEFORE DELETE
ON academic_failure FOR EACH ROW
BEGIN 
	IF  old.failure_subject IN (SELECT failure_subject FROM student_has_academic_failure) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in student_has_academic_failure
        connected with this data, you can't delete it";
	END IF;
END //