CREATE TABLE users
(
    is       SERIAL PRIMARY KEY,
    name     VARCHAR(124) NOT NULL,
    birthday DATE         NOT NULL,
    email    VARCHAR(124) NOT NULL UNIQUE,
    password VARCHAR(32)  NOT NULL,
    role     VARCHAR(32)  NOT NULL,
    gender   VARCHAR(16)  NOT NULL
)