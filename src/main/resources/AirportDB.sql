CREATE SCHEMA IF NOT EXISTS `AIRPORT` DEFAULT CHARACTER SET utf8;
USE `AIRPORT`;

CREATE TABLE Airline 
( id INT NOT NULL AUTO_INCREMENT,
  airlineName VARCHAR(32) NOT NULL,
  PRIMARY KEY (City)
) ENGINE = InnoDB;

CREATE TABLE Plane 
(
  id INT NOT NULL AUTO_INCREMENT,
  planeNumber VARCHAR(32) NOT NULL,
  capacity INT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE Counry 
(
  country VARCHAR(25) NOT NULL,
  PRIMARY KEY (Country)
) ENGINE = InnoDB;

CREATE TABLE City 
( id INT NOT NULL AUTO_INCREMENT,
  cityName VARCHAR(25) NOT NULL,
  cityCountry VARCHAR(25) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (cityCountry) 
    REFERENCES Country (country)
) ENGINE = InnoDB;

CREATE TABLE Address 
(
  id INT NOT NULL AUTO_INCREMENT,
  city INT NOT NULL,
  street VARCHAR(45) NOT NULL,
  buildNumber INT NOT NULL,
  flatNumber INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (city) 
    REFERENCES city (id)
) ENGINE = InnoDB;

CREATE TABLE ContactDetails
(
  id INT NOT NULL AUTO_INCREMENT,
  email VARCHAR(16) NOT NULL,
  phone VARCHAR(16) NOT NULL,
  address INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (address) 
    REFERENCES Address (id)
) ENGINE = InnoDB;

CREATE TABLE  Passager 
(
  id INT NOT NULL AUTO_INCREMENT,
  secontName VARCHAR(25) NOT NULL,
  firstName VARCHAR(25) NOT NULL,
  nationality VARCHAR(16) NOT NULL,  
  age INT NOT NULL,
  contacts INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (contacts) 
    REFERENCES ContactDetails (id)
) ENGINE = InnoDB;

CREATE TABLE  Flight
(
  flightNumber INT NOT NULL AUTO_INCREMENT,
  airlineId INT NOT NULL,
  planeId INT NOT NULL,
  departureCity INT NOT NULL,
  destinationCity INT NOT NULL,
  departureTime datetime NOT NULL,
  arrivalTime datetime NOT NULL,
  PRIMARY KEY (flightNumber),
  CONSTRAINT FOREIGN KEY (airlineId) 
    REFERENCES Airline (id),
  CONSTRAINT FOREIGN KEY (planeId) 
    REFERENCES Plane (id),
  CONSTRAINT FOREIGN KEY (departureCity, destinationCity) 
    REFERENCES City (id)
) ENGINE = InnoDB;

CREATE TABLE  FlightBooking
(
  bookingId INT NOT NULL AUTO_INCREMENT,
  flightNumber INT NOT NULL,
  passagerId INT NOT NULL,
  seat VARCHAR(16) NOT NULL,
  PRIMARY KEY (bookingId),
  CONSTRAINT FOREIGN KEY (flightNumber) 
    REFERENCES Flight (flightNumber),
  CONSTRAINT FOREIGN KEY (passagerId) 
    REFERENCES Passager (id)
) ENGINE = InnoDB;

