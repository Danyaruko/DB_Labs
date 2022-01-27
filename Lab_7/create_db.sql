CREATE DATABASE IF NOT EXISTS `Patana_7_64`;
USE `Patana_7_64` ;

DROP TABLE IF EXISTS `student`;
DROP TABLE IF EXISTS `class`;
DROP TABLE IF EXISTS `city`;
DROP TABLE IF EXISTS `finished_secondary_school`;
DROP TABLE IF EXISTS `oblast'`;
DROP TABLE IF EXISTS `academic_failure`;
DROP TABLE IF EXISTS `student_has_academic_failure`;

CREATE TABLE `student` (
  `student_id` VARCHAR(10) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `middle_name` VARCHAR(45) NOT NULL,
  `birth_date` DATE,
  `enrollment_date` DATE,
  `overall_rating` INT,
  `email` VARCHAR(45),
  `class_id` VARCHAR(5) NOT NULL,
  `city_of_residence_name` VARCHAR(45) NOT NULL,
  `finished_secondary_school_name` VARCHAR(45) NOT NULL,
  
  CONSTRAINT `pk_student` PRIMARY KEY (`student_id`)
  );

CREATE TABLE `class` (
  `class_id` VARCHAR(5) NOT NULL,
  `class_name` VARCHAR(45),
  `enrollment_date` DATETIME,
  
  CONSTRAINT `pk_class` PRIMARY KEY (`class_id`)
  );

CREATE TABLE `city` (
  `city_name` VARCHAR(45) NOT NULL,
  `oblast'_id` VARCHAR(2) NOT NULL,
  
 CONSTRAINT `pk_city` PRIMARY KEY (`city_name`, `oblast'_id`)
 );

CREATE TABLE `finished_secondary_school` (
  `secondary_school_name` VARCHAR(45) NOT NULL,
  `principals_phone_number` VARCHAR(13),
  `principals_full_name` VARCHAR(45),
  `location_city_name` VARCHAR(45) NOT NULL,
  
  CONSTRAINT `pk_finished_secondary_school` PRIMARY KEY (`secondary_school_name`)
  );

CREATE TABLE `oblast'` (
  `oblast'_id` VARCHAR(2) NOT NULL,
  `oblast'_name` VARCHAR(45),
  
  CONSTRAINT `pk_oblast'` PRIMARY KEY (`oblast'_id`)
  );
  
INSERT INTO `oblast'`(`oblast'_id`, `oblast'_name`) VALUES("01", "AR Krym"), ("05","Vynnyts'ka"), ("07","Volyns'ka"), 
  ("12","Dnipropetrovs'ka"), ("14","Donets'ka"), ("18","Zhytomyrs'ka"), ("21","Zakarpats'ka"), ("23","Zaporiz'ka"), 
  ("26","Ivano-Frankivs'ka"), ("32","Kyivs'ka"), ("35","Kirovograds'ka"), ("44","Luhans'ka"), 
  ("46","L'vivs'ka"), ("48","Mykolayivs'ka"), ("51","Odes'ka"), ("53","Poltavs'ka"), ("56","Rivnens'ka"), 
  ("59","Sums'ka"), ("61","Ternopil's'ka"), ("63","Kharkivs'ka"), ("65","Khersons'ka"), ("68","Hmel'nyts'ka"), 
  ("71","Cherkas'ka"), ("73","Chernivets'ka"), ("74","Chernyhivs'ka"), ("80","c. Kyiv"), ("85","c. Sevastopol'");

CREATE TABLE `academic_failure` (
  `failure_subject` VARCHAR(45) NOT NULL,
  
  CONSTRAINT `pk_academic_failure` PRIMARY KEY (`failure_subject`)
  );

CREATE TABLE `student_has_academic_failure` (
  `student_id` VARCHAR(10) NOT NULL,
  `failure_subject` VARCHAR(45) NOT NULL,
  
  CONSTRAINT `pk_student_has_academic_failure` PRIMARY KEY (`student_id`, `failure_subject`)
  );
