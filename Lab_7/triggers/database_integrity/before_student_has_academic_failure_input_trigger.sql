USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS before_student_has_academic_failure_input //
CREATE TRIGGER before_student_has_academic_failure_input
BEFORE INSERT 
ON student_has_academic_failure FOR EACH ROW
BEGIN 
	IF new.student_id NOT IN (SELECT student_id FROM student) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such student_id found in student.student_id
        for student_has_academic_failure.student_id";
	END IF;
    
    IF new.failure_subject NOT IN (SELECT failure_subject FROM academic_failure) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such failure_subject found in academuc_failure.failure_subject
        for student_has_academic_failure.failure_subject";
	END IF;
END //