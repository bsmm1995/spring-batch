DROP TABLE Person IF EXISTS;

CREATE TABLE person
(
    id         BIGINT IDENTITY NOT NULL PRIMARY KEY,
    name VARCHAR(20),
    last_name  VARCHAR(20),
    phone      VARCHAR(10)
);