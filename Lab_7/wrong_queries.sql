USE Patana_7_64;\

-- Insert into student with wrong group_id, city_of_residence_name_ or finshed_secondary_school_name
-- CALL insert_into_student("A00000453A", "Danylo", "Patana", "Anatoliyovych", "2002-05-19", 
-- "2020-09-01", 47, "danilpatana1905@gmail.com", "IR-21", "Zhmerynka", "L'vivskyi Phizyco-Matematychnyy Licey"); 
-- CALL insert_into_student("A00000344A", "Danylo", "Patana", "Anatoliyovych", "2002-05-19", 
-- "2020-09-01", 47, "danilpatana1905@gmail.com", "IR-41", "L'viv", "L'vivskyi Phizyco-Matematychnyy Licey"); 
-- CALL insert_into_student("A00000444A", "Danylo", "Patana", "Anatoliyovych", "2002-05-19", 
-- "2020-09-01", 47, "danilpatana1905@gmail.com", "IR-21", "L'viv", "Kozyatyns'ka shkola"); 

-- Update student with wrong class_id, city_of_residence_name or finshed_secondary_school_name
-- UPDATE student SET city_of_residence_name = "Kozyatyn" WHERE city_of_residence_name = "Zhovkva";
-- UPDATE student SET class_id = "MT-34" WHERE  city_of_residence_name =  "Zhovkva";
-- UPDATE student SET finished_secondary_school_name = "None" WHERE  city_of_residence_name = "Zhovkva";

-- Delet student with academic failures
-- DELETE FROM student WHERE surname = "Generic";

-- Delete tuple in class connected with student
-- DELETE FROM class WHERE class_id = "IR-21";

-- Insert into/update/delete from oblast' table
-- INSERT INTO `oblast'`(`oblast'_id`, `oblast'_name`) VALUES(69, "Krasnodars'ka");
-- UPDATE `oblast'` SET `oblast'_name` = 'Malorossiyskaya';
-- DELETE FROM `oblast'` WHERE `oblast'_name` = "AR Krym";

-- Delete tuple from academic_failure connected with student_has_academic_failure
-- DELETE FROM academic_failure WHERE failure_subject = 'High Math'; 

-- Delete tuple from finished_secondary_school connected with student
-- DELETE FROM finished_secondary_school WHERE location_city_name = "L'viv";

-- Insert tuple into finished_secondary_school with wrong city
-- INSERT INTO finished_secondary_school(secondary_school_name, location_city_name) VALUES ("Bakhchysarayskiy minaret", "Bakhchisaray");

-- Update finished_secondary_school city 
-- UPDATE finished_secondary_school SET location_city_name = "L'viv" WHERE location_city_name = "Zhovkva";

-- Insert tuple into student_has_academic_failure with wrong student_id
-- INSERT INTO student_has_academic_failure(student_id, failure_subject) VALUES ("A33323456F", "High Math");

-- Insert tuple into student_has_academic_failure with wrong failure_subject
-- INSERT INTO student_has_academic_failure(student_id, failure_subject) VALUES ("A00123456F", "PE");

-- Insert tuple into city with wrong oblast'_id
-- CALL insert_into_city("Peremyshl'", "39");

-- Update city oblast'
-- UPDATE city SET `oblast'_id` = '01' WHERE city_name = "Zhovkva";

-- Delete city connected to student or secondary_school
-- DELETE FROM city WHERE city_name = "L'viv";

-- Add class over limit of six
-- CALL insert_into_class("MT-21","Metrologiya 2 kurs 1 grupa","2020-09-01");

-- Add student with wrong student_id
-- CALL insert_into_student("A00000453S", "Danylo", "Patana", "Anatoliyovych", "2002-05-19", 
-- "2020-09-01", 47, "danilpatana1905@gmail.com", "IR-21", "L'viv", "L'vivskyi Phizyco-Matematychnyy Licey"); 

-- Add student with wrong age
-- CALL insert_into_student("A00032453A", "Danylo", "Patana", "Anatoliyovych", "2005-05-19", 
-- "2020-09-01", 47, "danilpatana1905@gmail.com", "IR-21", "L'viv", "L'vivskyi Phizyco-Matematychnyy Licey"); 
