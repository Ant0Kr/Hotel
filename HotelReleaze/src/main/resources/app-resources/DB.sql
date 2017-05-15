DROP DATABASE IF EXISTS hotel;
CREATE DATABASE IF NOT EXISTS hotel;
USE hotel;

DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users(
  userID INT AUTO_INCREMENT,
  username VARCHAR(40),
  password VARCHAR(40),
  role BOOLEAN,
  PRIMARY KEY (userID)
);

DROP TABLE IF EXISTS hotelRooms;
CREATE TABLE IF NOT EXISTS hotelRooms(
  numbersID INT AUTO_INCREMENT,
  state BOOLEAN,
  userID INT,
  PRIMARY KEY (numbersID)
);

USE hotel;
INSERT INTO users(username,password,role)VALUES('admin','admin',TRUE );
INSERT INTO users(username,password,role)VALUES('user','user',FALSE );
INSERT INTO hotelRooms(state)VALUES(FALSE);
INSERT INTO hotelRooms(state)VALUES(FALSE);
INSERT INTO hotelRooms(state)VALUES(FALSE);
INSERT INTO hotelRooms(state)VALUES(FALSE);
INSERT INTO hotelRooms(state)VALUES(FALSE);
INSERT INTO hotelRooms(state)VALUES(FALSE);
INSERT INTO hotelRooms(state)VALUES(FALSE);
INSERT INTO hotelRooms(state)VALUES(FALSE);
INSERT INTO hotelRooms(state)VALUES(FALSE);
