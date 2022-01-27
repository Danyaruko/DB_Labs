USE Patana_7_64;

DELIMITER //
DROP PROCEDURE IF EXISTS `insert_into_class` //
CREATE PROCEDURE `insert_into_class` (
    IN `class_id` VARCHAR(5),
	IN `class_name` VARCHAR(45),
    IN `enrollment_date` DATETIME
    )
BEGIN
	INSERT INTO `class`(`class_id`, `class_name`, `enrollment_date` ) 
    VALUES(`class_id`, `class_name`, `enrollment_date`);
END //