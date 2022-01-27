USE Patana_7_64;

DELIMITER //
DROP TRIGGER IF EXISTS `before_oblast'_insert` //
CREATE TRIGGER `before_oblast'_insert`
BEFORE INSERT 
ON `oblast'` FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "Immutability error. Oblast' table is immutable.
    If you believe information in this table to be outdated, please contact me.";
END //

DROP TRIGGER IF EXISTS `before_oblast'_update` //
CREATE TRIGGER `before_oblast'_update`
BEFORE UPDATE
ON `oblast'` FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "Immutability error. Oblast' table is immutable.
    If you believe information in this table to be outdated, please contact me.";
END //

DROP TRIGGER IF EXISTS `before_oblast'_delete` //
CREATE TRIGGER `before_oblast'_delete`
BEFORE DELETE
ON `oblast'` FOR EACH ROW
BEGIN 
	SIGNAL SQLSTATE '45000'
	SET MESSAGE_TEXT = "Immutability error. Oblast' table is immutable.
    If you believe information in this table to be outdated, please contact me.";
END //