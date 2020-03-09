CREATE SCHEMA IF NOT EXISTS `AIRPORT` DEFAULT CHARACTER SET utf8;
USE `AIRPORT`;

CREATE TABLE Airline 
( id INT NOT NULL AUTO_INCREMENT,
  airlineName VARCHAR(32) NOT NULL,
  address INT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FOREIGN KEY (address)
    REFERENCES Address (id)
) ENGINE = InnoDB;

CREATE TABLE Plane
(
  id INT NOT NULL AUTO_INCREMENT,
  planeNumber VARCHAR(32) NOT NULL,
  capacity INT NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB;

CREATE TABLE Country
(
  country VARCHAR(25) NOT NULL,
  isEu   boolean NOT NULL,
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
    REFERENCES City (id)
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
  CONSTRAINT FOREIGN KEY (departureCity)
    REFERENCES City (id),
  CONSTRAINT FOREIGN KEY (destinationCity)
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

INSERT INTO `AIRPORT`.`Plane`
(`planeNumber`,
`capacity`)
VALUES
("AH150", 100),
("MK1800", 200),
("BN132", 150),
("JKL32", 72),
("LPU458", 210);


INSERT INTO `AIRPORT`.`Airline`
(`airlineName`)
VALUES
("Wizzair"),
("Ryanair"),
("Lufthansa"),
("Turkish airlines");

INSERT INTO `AIRPORT`.`Country`
(`country`, isEu)
VALUES
("Ukraine", 0),
("Poland", 1),
("Italy", 1),
("Austria", 1),
("Germany", 1),
("Spain", 1);

INSERT INTO `AIRPORT`.`City`
(`cityName`,
`cityCountry`)
VALUES
("Lviv", "Ukraine"),
("Kyiv", "Ukraine"),
("Kharkiv", "Ukraine"),
("Odessa", "Ukraine"),
("Gdansk", "Poland"),
("Krakow", "Poland"),
("Warszawa", "Poland"),
("Vienna", "Austria"),
("Berlin", "Germany"),
("Barselona", "Spain"),
("Roma", "Italy"),
("Naples", "Italy"),
("Milan", "Italy"),
("Venice", "Italy");

INSERT INTO `AIRPORT`.`Address`
(`city`,
`street`,
`buildNumber`,
`flatNumber`)
VALUES
(43,"Hirnyka", 1, 31),
(43,"Franka", 5, 56),
(44,"Shevchenka", 7, 117);

INSERT INTO `AIRPORT`.`ContactDetails`
(`email`, `phone`, `address`)
VALUES
( "ivan.i@gmail.com", "+380345689555", 3),
( "roman@gmail.com", "+380675689666", 2),
( "anna.v@gmail.com", "+38098000000", 1);

INSERT INTO `AIRPORT`.`Passager`
(`secontName`,
`firstName`,
`nationality`,
`age`,
`contacts`)
VALUES
("Ivanov", "Ivan", "Ukraine", 25, 7),
("Romanov", "Roman", "Ukraine", 45, 8),
("Volunets", "Anna", "Ukraine", 26, 9);

INSERT INTO `AIRPORT`.`Flight`
(`airlineId`,
`planeId`,
`departureCity`,
`destinationCity`,
`departureTime`,
`arrivalTime`)
VALUES
(2, 1, 43, 44, '2020-03-12 17:55:00', '2020-03-12 18:45:00'),
(1, 2, 43, 48, '2020-04-18 17:55:00', '2020-04-18 18:55:00'),
(3, 3, 48, 43, '2020-04-21 13:45:00', '2020-04-21 14:45:00'),
(2, 4, 48, 55, '2020-05-18 19:15:00', '2020-05-18 20:55:00'),
(4, 5, 51, 56, '2020-03-17 14:49:00', '2020-03-17 15:59:00');


INSERT INTO `AIRPORT`.`FlightBooking`
(`flightNumber`,
`passagerId`,
`seat`)
VALUES
(1, 1, "2A"),
(2, 1, "3B"),
(3, 2, "17A"),
(4, 3, "7C"),
(5, 3, "8D");













