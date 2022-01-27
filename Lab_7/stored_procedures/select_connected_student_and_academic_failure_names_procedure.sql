USE Patana_7_64;

DELIMITER //
DROP PROCEDURE IF EXISTS select_connected_student_and_academic_failure_names //
CREATE PROCEDURE `select_connected_student_and_academic_failure_names` (IN student_name VARCHAR(45), IN student_surname VARCHAR(45),
IN student_middle_name VARCHAR(45), IN failure_subject VARCHAR(45))
BEGIN
	SELECT student.name, student.surname, student.middle_name, academic_failure.failure_subject FROM student_has_academic_failure AS docking_table
    INNER JOIN student ON docking_table.student_id = student.student_id
    INNER JOIN academic_failure ON docking_table.failure_subject = academic_failure.failure_subject
    WHERE (student_name = '' OR student.name = student_name) 
    AND (student_surname = '' OR student.surname = student_surname)
    AND (student_middle_name = '' OR student.middle_name = student_middle_name)
    AND (failure_subject = '' OR academic_failure.failure_subject = failure_subject);
END //