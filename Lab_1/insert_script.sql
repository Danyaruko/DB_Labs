USE patana;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM bus_has_driver;
DELETE FROM driver_has_route;
DELETE FROM bus;
DELETE FROM stops;
DELETE FROM driver;
DELETE FROM company;
DELETE FROM route;


ALTER TABLE company AUTO_INCREMENT = 1; 
ALTER TABLE driver AUTO_INCREMENT = 1;
ALTER TABLE route AUTO_INCREMENT = 1;
ALTER TABLE stops AUTO_INCREMENT = 1;

INSERT INTO route(start_point, end_point, route_price_EUR, length_km) 
VALUES
('Durka1', 'Durka2', 2, 22.8),
('Durka2', 'adress2', 5, 14.88),
('Durka3', 'adress3', 10, 148),
('Durka4', 'adress4', 3, 15),
('Durka5', 'adress5', 7, 50);

INSERT INTO company(name, country) 
VALUES
('DurkaBuses1', 'Durkastan1'),
('DurkaBuses2', 'Durkastan2'),
('DurkaBuses3', 'Durkaland3'),
('DurkaBuses4', 'Durka'),
('DurkaBuses5', 'United States of Durka');

INSERT INTO driver(full_name, phone_number, email, age) 
VALUES
('Jhon Doe', '+380384233', 'jhondoe1@gmail.com', 39),
('Hon Droe', '+380484939', 'jhondoe2@gmail.com', 74),
('Jan Duj', '+380483994', 'jhondoe3@gmail.com', 26),
('Jane Doe', '+380586392', 'jhondoe4@gmail.com', 34),
('Jake Doe', '+380959406', 'jhondoe5@gmail.com', 44);

INSERT INTO stops(name, price_EUR, distance_km, previous_stop_id, route_id) 
VALUES
('Durka', 1.5, 22, null, 3),
('Iskra', 1.0, 16, 1, 3),
('Janovka', 0.5, 7, null, 2),
('Kurovo', 0.25, 2, 2, 3),
('Gert', 0.1, 0.5, 3, 2);

INSERT INTO bus(bus_number, mileage_km, manufacturer, age, seats, id_route, owner_company_id) 
VALUES
('BC3453AE', 444, 'ZAZ', 15, 42, 2, 3),
('AA4680OA', 4443, 'Mercedes', 40, 129, 3, 1),
('AH6795BT', 1444, 'BMW', 6, 50, 4, 2),
('AI3694OI', 44234, 'Lada', 7, 99, 5, 3),
('KE5294TE', 443454, 'ZAZ', 18, 13, 2, 4);

INSERT INTO driver_has_route(driver_id, route_id)
VALUES
(3, 2),
(2, 3),
(4, 3),
(1, 2),
(5, 2);

INSERT INTO bus_has_driver(bus_number, driver_id)
VALUES
('AA4680OA', 2),
('BC3453AE', 3),
('KE5294TE', 5),
('AH6795BT', 1),
('AI3694OI', 4);
SET SQL_SAFE_UPDATES = 1;
