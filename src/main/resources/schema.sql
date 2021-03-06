DROP TABLE IF EXISTS books;

CREATE TABLE  books(
id INT AUTO_INCREMENT PRIMARY KEY,
id_author INT (10) DEFAULT 0,
author VARCHAR(250) NOT NULL,
title VARCHAR(250) NOT NULL,
priceOld  VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL
);

CREATE TABLE authors(
    id INT AUTO_INCREMENT PRIMARY KEY ,
    author VARCHAR (250) NOT NULL,
    biography VARCHAR (8000) NOT NULL,
    photo VARCHAR(250) NOT NULL
);