-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Patana
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Patana
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Patana` DEFAULT CHARACTER SET utf8 ;
USE `Patana` ;

-- -----------------------------------------------------
-- Table `Patana`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Patana`.`route` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `start_point` VARCHAR(45) NULL,
  `end_point` VARCHAR(45) NULL,
  `route_price_EUR` INT NULL,
  `length_km` FLOAT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Patana`.`company`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Patana`.`company` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Patana`.`bus`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Patana`.`bus` (
  `bus_number` VARCHAR(12) NOT NULL,
  `mileage_km` FLOAT NULL,
  `manufacturer` VARCHAR(45) NULL,
  `age` INT NULL,
  `seats` INT NULL,
  `id_route` INT NOT NULL,
  `owner_company_id` INT NOT NULL,
  PRIMARY KEY (`bus_number`),
  INDEX `fk_Bus_Route1_idx` (`id_route` ASC) VISIBLE,
  INDEX `fk_Bus_Company1_idx` (`owner_company_id` ASC) VISIBLE,
  CONSTRAINT `fk_Bus_Route1`
    FOREIGN KEY (`id_route`)
    REFERENCES `Patana`.`route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Bus_Company1`
    FOREIGN KEY (`owner_company_id`)
    REFERENCES `Patana`.`company` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Patana`.`driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Patana`.`driver` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL,
  `phone_number` VARCHAR(20) NULL,
  `email` VARCHAR(45) NULL,
  `age` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Patana`.`stops`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Patana`.`stops`;
CREATE TABLE IF NOT EXISTS `Patana`.`stops` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `price_EUR` FLOAT NULL,
  `distance_km` FLOAT NULL,
  `previous_stop_id` INT NULL,
  `route_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Stop_Stop1_idx` (`previous_stop_id` ASC) VISIBLE,
  INDEX `fk_Stop_Route1_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `fk_Stop_Stop1`
    FOREIGN KEY (`previous_stop_id`)
    REFERENCES `Patana`.`stops` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Stop_Route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `Patana`.`route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Patana`.`driver_has_route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Patana`.`driver_has_route` (
  `driver_id` INT NOT NULL,
  `route_id` INT NOT NULL,
  PRIMARY KEY (`driver_id`, `route_id`),
  INDEX `fk_driver_has_route_route1_idx` (`route_id` ASC) VISIBLE,
  INDEX `fk_driver_has_route_driver1_idx` (`driver_id` ASC) VISIBLE,
  CONSTRAINT `fk_driver_has_route_driver1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `Patana`.`driver` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_driver_has_route_route1`
    FOREIGN KEY (`route_id`)
    REFERENCES `Patana`.`route` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Patana`.`bus_has_driver`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Patana`.`bus_has_driver` (
  `bus_number` VARCHAR(12) NOT NULL,
  `driver_id` INT NOT NULL,
  PRIMARY KEY (`bus_number`, `driver_id`),
  INDEX `fk_bus_has_driver_driver1_idx` (`driver_id` ASC) VISIBLE,
  INDEX `fk_bus_has_driver_bus1_idx` (`bus_number` ASC) VISIBLE,
  CONSTRAINT `fk_bus_has_driver_bus1`
    FOREIGN KEY (`bus_number`)
    REFERENCES `Patana`.`bus` (`bus_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_bus_has_driver_driver1`
    FOREIGN KEY (`driver_id`)
    REFERENCES `Patana`.`driver` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
