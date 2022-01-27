USE Patana_7_64;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //
DROP FUNCTION IF EXISTS student_average_overall_rating //
CREATE FUNCTION student_average_overall_rating()
RETURNS DECIMAL(10,2) 
BEGIN
    return(SELECT AVG(overall_rating) FROM student);
END//