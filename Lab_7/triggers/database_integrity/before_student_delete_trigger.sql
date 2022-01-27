USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS before_student_delete //
CREATE TRIGGER before_student_delete
BEFORE DELETE
ON student FOR EACH ROW
BEGIN 
	IF  old.student_id IN (SELECT student_id FROM student_has_academic_failure) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. There is at least one tuple in student_has_academic_failure
        connected with this data, you can't delete it";
	END IF;
END //