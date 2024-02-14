CREATE TABLE telbook.user

(
    id SERIAL PRIMARY KEY,
    name                VARCHAR(255),
    date_of_birth       VARCHAR(255),
    phone_number        VARCHAR(255),
    second_phone_number VARCHAR(255),
    date_create         timestamp default current_timestamp,
    date_update         timestamp default current_timestamp
);