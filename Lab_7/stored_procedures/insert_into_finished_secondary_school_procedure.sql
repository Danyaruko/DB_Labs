USE Patana_7_64;

DELIMITER //
DROP PROCEDURE IF EXISTS insert_into_finished_secondary_school //
CREATE PROCEDURE `insert_into_finished_secondary_school` (
    IN secondary_school_name VARCHAR(45),
	IN principals_phone_number VARCHAR(13),
    IN principals_full_name VARCHAR(45),
    IN location_city_name VARCHAR(45)
    )
BEGIN
	INSERT INTO finished_secondary_school(secondary_school_name, principals_phone_number, principals_full_name,
    location_city_name ) 
    VALUES(secondary_school_name, principals_phone_number, principals_full_name,
    location_city_name );
END //