create database hospital;
use hospital;
-- Create Patient table
CREATE TABLE Patient (
    patientId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(25) NOT NULL,
    lastName VARCHAR(25) NOT NULL,
    dateOfBirth VARCHAR(10),
    gender VARCHAR(10),
    contactNumber VARCHAR(20),
    address VARCHAR(225)
)AUTO_INCREMENT = 101 ;

-- Create Doctor table
CREATE TABLE Doctor (
    doctorId INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(25) NOT NULL,
    lastName VARCHAR(25) NOT NULL,
    specialization VARCHAR(25),
    contactNumber VARCHAR(20)
) AUTO_INCREMENT = 01 ;

-- Create Appointment table
CREATE TABLE Appointment (
    appointmentId INT PRIMARY KEY AUTO_INCREMENT,
    patientId INT,
    doctorId INT,
    appointmentDate VARCHAR(10),
    description VARCHAR(225),
    FOREIGN KEY (patientId) REFERENCES Patient(patientId),
    FOREIGN KEY (doctorId) REFERENCES Doctor(doctorId)
)AUTO_INCREMENT = 1001 ;