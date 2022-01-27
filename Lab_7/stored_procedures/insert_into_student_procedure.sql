USE Patana_7_64;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_into_student //
CREATE PROCEDURE `insert_into_student` (
    IN student_id CHAR(20),
	IN name VARCHAR(45),
    IN surname VARCHAR(45),
    IN middle_name VARCHAR(45),
    IN birth_date DATETIME,
    IN enrollment_date DATETIME,
    IN overall_rating INT,
    IN email VARCHAR(45),
    IN class_id VARCHAR(5),
    IN city_of_residence_name VARCHAR(45),
    IN finished_secondary_school_name VARCHAR(45)
    )
BEGIN
	INSERT INTO student(student_id, name, surname, middle_name, birth_date, enrollment_date, overall_rating, email, 
    class_id, city_of_residence_name, finished_secondary_school_name ) 
    VALUES(student_id, name, surname, middle_name, birth_date, enrollment_date, overall_rating, email, class_id, 
    city_of_residence_name, finished_secondary_school_name);
END //