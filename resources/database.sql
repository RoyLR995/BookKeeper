CREATE DATABASE bookkeeper;

USE bookkeeper;

CREATE TABLE books (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    author VARCHAR(255),
    genre VARCHAR(255),
    notes TEXT
);
