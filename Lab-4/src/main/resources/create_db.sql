CREATE SCHEMA IF NOT EXISTS `patana`;
USE `patana` ;

DROP TABLE IF EXISTS bus_driver;
DROP TABLE IF EXISTS driver_route;
DROP TABLE IF EXISTS driver;
DROP TABLE IF EXISTS stops;
DROP TABLE IF EXISTS bus;
DROP TABLE IF EXISTS route;
DROP TABLE IF EXISTS company;
DROP TABLE IF EXISTS manufacturer;
DROP TABLE IF EXISTS location;

CREATE TABLE route (
	id INT AUTO_INCREMENT,
    start_point VARCHAR(45) NOT NULL, 
    end_point VARCHAR(45) NOT NULL,
    route_price_EUR INT,
    length_km FLOAT ,
    
    CONSTRAINT pk_route PRIMARY KEY (id)
);

CREATE TABLE stops (
   id INT AUTO_INCREMENT,
   name VARCHAR(45),
   price_EUR FLOAT,
   distance_km FLOAT,
   previous_stop_id INT NOT NULL,
   route_id INT NOT NULL,

  CONSTRAINT pk_stops PRIMARY KEY (id),
  CONSTRAINT fk_stops_stops
  FOREIGN KEY (previous_stop_id)
   REFERENCES stops (id),
  CONSTRAINT fk_stops_route
  FOREIGN KEY (route_id)
   REFERENCES route (id)
);

CREATE TABLE location (
    id INT AUTO_INCREMENT,
    country VARCHAR(45),
    city VARCHAR(45),
    street VARCHAR(45),
    
  CONSTRAINT pk_location PRIMARY KEY (id)
);

CREATE TABLE company (
    id INT AUTO_INCREMENT,
    name VARCHAR(45),
    location_id INT NOT NULL,
    
  CONSTRAINT pk_company PRIMARY KEY (id),
  CONSTRAINT fk_company_location 
  FOREIGN KEY (location_id)
   REFERENCES location (id)
);

CREATE TABLE manufacturer (
    id INT AUTO_INCREMENT,
    name VARCHAR(45),
    location_id INT NOT NULL,
    
  CONSTRAINT pk_manufacturer PRIMARY KEY (id),
  CONSTRAINT fk_manufacturer_loction
  FOREIGN KEY (location_id)
   REFERENCES location (id)
);

CREATE TABLE bus (
    bus_number VARCHAR(12),
    mileage_km FLOAT,
    age INT,
    seats INT,
    id_route INT NOT NULL,
    owner_company_id INT NOT NULL,
    manufacturer_id INT NOT NULL,
    
    CONSTRAINT pk_bus PRIMARY KEY (bus_number),
    CONSTRAINT fk_bus_route 
    FOREIGN KEY (id_route)
     REFERENCES route (id),
	CONSTRAINT fk_bus_company
	FOREIGN KEY (owner_company_id)
     REFERENCES company (id),
	CONSTRAINT fk_bus_manufacturer
    FOREIGN KEY (manufacturer_id)
     REFERENCES manufacturer (id)
);

CREATE TABLE driver (
    id INT AUTO_INCREMENT,
    full_name VARCHAR(45),
    phone_number VARCHAR(20),
    email VARCHAR(45),
    age INT,
    
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE  bus_driver (
    bus_number VARCHAR(12) NOT NULL,
    driver_id INT NOT NULL,
    
    CONSTRAINT pk_bus_driver PRIMARY KEY (bus_number, driver_id),
    CONSTRAINT fk_bus_driver_bus
    FOREIGN KEY (bus_number)
     REFERENCES bus (bus_number),
	CONSTRAINT fk_bus_driver_driver
    FOREIGN KEY (driver_id)
     REFERENCES driver (id)
);

CREATE TABLE driver_route (
    driver_id INT NOT NULL,
    route_id INT NOT NULL,
    
    CONSTRAINT pk_driver_route PRIMARY KEY (driver_id, route_id),
    CONSTRAINT fk_driver_route_driver 
    FOREIGN KEY (driver_id)
     REFERENCES driver (id),
	CONSTRAINT fk_driver_route_route
    FOREIGN KEY (route_id)
     REFERENCES route (id)
);
