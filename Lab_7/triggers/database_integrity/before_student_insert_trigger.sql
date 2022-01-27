USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS before_student_input //
CREATE TRIGGER before_student_input
BEFORE INSERT 
ON student FOR EACH ROW
BEGIN 
	IF new.class_id NOT IN (SELECT class_id FROM `class`) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such class_id found in class.class_id
        for student.class_id";
	END IF;
    
    IF new.city_of_residence_name NOT IN (SELECT city_name FROM city) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such city_of_residence_name found in city.city_name
        for student.city_of_residence_name";
	END IF;
    
    IF new.finished_secondary_school_name NOT IN (SELECT secondary_school_name FROM finished_secondary_school) THEN
		SIGNAL SQLSTATE '45000'
		SET MESSAGE_TEXT = "FK error. No such secondary_school_name found in finished_secondary_school.secondary_school_name
        for student.finished_secondary_school_name";
	END IF;
END //