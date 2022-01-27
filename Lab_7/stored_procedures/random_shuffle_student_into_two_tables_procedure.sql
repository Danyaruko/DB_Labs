USE Patana_7_64;

DELIMITER //
DROP PROCEDURE IF EXISTS add_quotes //
CREATE PROCEDURE `add_quotes` (INOUT s VARCHAR(100))
BEGIN
	SET s = CONCAT('"',s,'"');
END //

DROP PROCEDURE IF EXISTS random_shuffle_student_into_two_tables //
CREATE PROCEDURE `random_shuffle_student_into_two_tables` ()
BEGIN
	DECLARE finished BOOL DEFAULT FALSE;
    DECLARE student_id VARCHAR(12);
    DECLARE name VARCHAR(45);
    DECLARE surname VARCHAR(45);
    DECLARE middle_name VARCHAR(45);
    DECLARE birth_date VARCHAR(45);
    DECLARE enrollment_date VARCHAR(45);
    DECLARE overall_rating INT;
    DECLARE email VARCHAR(45);
    DECLARE class_id VARCHAR(7);
    DECLARE city_of_residence_name VARCHAR(45);
    DECLARE finished_secondary_school_name VARCHAR(45);
    DECLARE student_cursor CURSOR FOR SELECT * FROM student;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET finished = TRUE;
	SET @cur_date = CURDATE();
    SET @cur_time = CURTIME();
    SET @slice_table_1_name = CONCAT("slice_student_table_", @cur_date, "-", @cur_time,"_1");
    SET @create_slice_table_1_query = CONCAT( 
    "CREATE TABLE `", @slice_table_1_name, "` (",
		"student_id VARCHAR(10),",
		"name VARCHAR(45) NOT NULL,",
		"surname VARCHAR(45) NOT NULL,",
		"middle_name VARCHAR(45) NOT NULL,",
		"birth_date DATE,",
		"enrollment_date DATE,",
		"overall_rating INT,",
		"email VARCHAR(45),",
		"class_id VARCHAR(5) NOT NULL,",	
		"city_of_residence_name VARCHAR(45) NOT NULL,",
		"finished_secondary_school_name VARCHAR(45) NOT NULL,",
		
        "CONSTRAINT pk_student PRIMARY KEY (student_id)",
	");");
	PREPARE statement FROM @create_slice_table_1_query;
    EXECUTE statement;
    DEALLOCATE PREPARE statement;
    SET @slice_table_2_name = CONCAT("slice_student_table_", @cur_date, "-", @cur_time, "_2");
    SET @create_slice_table_2_query = CONCAT(
    "CREATE TABLE `", @slice_table_2_name, "` (",
		"student_id VARCHAR(10),",
		"name VARCHAR(45) NOT NULL,",
		"surname VARCHAR(45) NOT NULL,",
		"middle_name VARCHAR(45) NOT NULL,",
		"birth_date DATE,",
		"enrollment_date DATE,",
		"overall_rating INT,",
		"email VARCHAR(45),",
		"class_id VARCHAR(5) NOT NULL,",	
		"city_of_residence_name VARCHAR(45) NOT NULL,",
		"finished_secondary_school_name VARCHAR(45) NOT NULL,",
		
        "CONSTRAINT pk_student PRIMARY KEY (student_id)",
	");");
    PREPARE statement FROM @create_slice_table_2_query;
    EXECUTE statement;
    DEALLOCATE PREPARE statement;
    
    OPEN student_cursor;
    student_loop: LOOP 
		FETCH student_cursor INTO student_id, name, surname, middle_name, birth_date, enrollment_date, overall_rating, email, 
		class_id, city_of_residence_name, finished_secondary_school_name;
        IF finished THEN
			LEAVE student_loop;
        END IF;
        CALL add_quotes(student_id);
        CALL add_quotes(name);
        CALL add_quotes(surname);
        CALL add_quotes(middle_name);
        CALL add_quotes(birth_date);
        CALL add_quotes(enrollment_date);
        CALL add_quotes(email);
        CALL add_quotes(class_id);
		CALL add_quotes(city_of_residence_name);
        CALL add_quotes(finished_secondary_school_name);
        IF RAND() >= 0.5 THEN
			SET @insert_query = CONCAT(
			"INSERT INTO `", @slice_table_1_name, "` (student_id, name, surname, middle_name, birth_date, enrollment_date, overall_rating, email, 
			class_id, city_of_residence_name, finished_secondary_school_name ) ", 
			"VALUES(", student_id, ",", name, ",", surname, ",", middle_name, ",", IFNULL(birth_date, "null"), ",", IFNULL(enrollment_date, "null"), ",", 
            IFNULL(overall_rating, "null"), ",", IFNULL(email, "null"), ",", IFNULL(class_id, "null"), ",",
			IFNULL(city_of_residence_name, "null"), ",", IFNULL(finished_secondary_school_name, "null"), ");");
		ELSE
			SET @insert_query = CONCAT(
			"INSERT INTO `", @slice_table_2_name, "` (student_id, name, surname, middle_name, birth_date, enrollment_date, overall_rating, email, 
			class_id, city_of_residence_name, finished_secondary_school_name ) ", 
			"VALUES(", student_id, ",", name, ",", surname, ",", middle_name, ",", IFNULL(birth_date, "null"), ",", IFNULL(enrollment_date, "null"), ",", 
            IFNULL(overall_rating, "null"), ",", IFNULL(email, "null"), ",", IFNULL(class_id, "null"), ",",
			IFNULL(city_of_residence_name, "null"), ",", IFNULL(finished_secondary_school_name, "null"), ");");
		END IF;
        PREPARE statement FROM @insert_query;
		EXECUTE statement;
		DEALLOCATE PREPARE statement;
	END LOOP;
	CLOSE student_cursor;
    
    SET @select_query = CONCAT(
    "SELECT * FROM `", @slice_table_1_name, "`",
    " UNION ", 
     "SELECT null, null, null, null, null, 'TABLE 1', null, null, null, null, null",
    " UNION ",
    "SELECT * FROM `", @slice_table_2_name, "`",
    " UNION ",
    "SELECT null, null, null, null, null, 'TABLE 2', null, null, null, null, null", ";");
    PREPARE statement FROM @select_query;
	EXECUTE statement;
	DEALLOCATE PREPARE statement;
END //