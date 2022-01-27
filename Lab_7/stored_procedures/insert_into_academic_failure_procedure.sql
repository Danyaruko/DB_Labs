USE Patana_7_64;

DELIMITER //
DROP PROCEDURE IF EXISTS `insert_into_academic_failure` //
CREATE PROCEDURE `insert_into_academic_failure` (
    IN failure_subject VARCHAR(45)
    )
BEGIN
	INSERT INTO `academic_failure`(failure_subject) 
    VALUES(failure_subject);
END //