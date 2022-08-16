DROP TABLE Person IF EXISTS;

CREATE TABLE Person
(
    id         BIGINT IDENTITY NOT NULL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name  VARCHAR(20),
    phone      VARCHAR(10)
);