USE Patana_7_64;

DELIMITER //
DROP PROCEDURE IF EXISTS clear_tables //
CREATE PROCEDURE clear_tables()
BEGIN
    DELETE FROM student_has_academic_failure;
	DELETE FROM student;
	DELETE FROM class;
	DELETE FROM academic_failure;
    DELETE FROM finished_secondary_school;
    DELETE FROM city;
END //