CREATE DATABASE nopaper_db;

USE nopaper_db;

CREATE USER 'nopaper_user'@'localhost' IDENTIFIED BY '6eq6u7j5@121#DB';
GRANT ALL PRIVILEGES ON nopaper_db.* TO 'nopaper_user'@'localhost';
FLUSH PRIVILEGES;


-- USER TABLE STRUCTURE:
CREATE TABLE users(
    user_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    PRIMARY KEY(user_id)
);