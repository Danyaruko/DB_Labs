USE Patana_7_64;
SET GLOBAL log_bin_trust_function_creators = 1;

DELIMITER //
DROP FUNCTION IF EXISTS `oblast'_retrieval` //
CREATE FUNCTION `oblast'_retrieval`(
	`oblast'_id` VARCHAR(2)
)
RETURNS VARCHAR(47)
BEGIN
    return(SELECT CONCAT(`oblast'_id`, ' ', `oblast'_name`) FROM `oblast'` WHERE `oblast'`.`oblast'_id`=`oblast'_id`);
END//