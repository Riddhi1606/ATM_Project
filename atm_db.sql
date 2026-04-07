CREATE DATABASE atm_db;
USE atm_db;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    pin INT,
    balance DOUBLE
);

INSERT INTO users (name, pin, balance)
VALUES 
('Riddhi', 1234, 5000),
('Saloni', 1111, 3000),
('Sai', 2222, 7000),
('Yashvardhan', 3333, 25000),
('Siddhi', 4444, 4100),
('Riddhi Mudgal', 5555, 7809);