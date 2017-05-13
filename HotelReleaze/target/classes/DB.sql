DROP DATABASE IF EXISTS hotel;
CREATE DATABASE IF NOT EXISTS hotel;
USE hotel;

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
  userID INT AUTO_INCREMENT,
  username VARCHAR(40),
  password VARCHAR(40),
  role VARCHAR(20),
  PRIMARY KEY (userID)
);

DROP TABLE IF EXISTS hotels;
CREATE TABLE IF NOT EXISTS hotels(
  hotelID INT AUTO_INCREMENT,
  hotelName VARCHAR(40),
  PRIMARY KEY (hotelID)
);

DROP TABLE IF EXISTS hotelNumbers;
CREATE TABLE IF NOT EXISTS hotelNumbers(
  numbersID INT AUTO_INCREMENT,
  hotelID INT,
  PRIMARY KEY (numbersID)
);

USE hotel;
INSERT INTO users(username,password,role)VALUES('antoha12018','llllllllll','ROLE_ADMIN');
INSERT INTO hotels(hotelName)VALUES('Sinyavka');
INSERT INTO hotelNumbers(hotelID)VALUES(1);