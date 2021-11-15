CREATE TABLE post (
    id SERIAL PRIMARY KEY,
    name TEXT,
    create_date timestamp with time zone
);

CREATE TABLE city (
    id SERIAL PRIMARY KEY,
    name TEXT
);

INSERT INTO city(name) values('Москва');
INSERT INTO city(name) values('Санкт-Петербург');
INSERT INTO city(name) values('Екатеринбург');
INSERT INTO city(name) values('Самара');
INSERT INTO city(name) values('Тольятти');
INSERT INTO city(name) values('Тюмень');
INSERT INTO city(name) values('Ханты-Мансийск');

CREATE TABLE candidate (
    id SERIAL PRIMARY KEY,
    name TEXT,
    cityId int,
    create_date timestamp with time zone,
    foreign key(cityId) references city(id)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name TEXT,
    email TEXT,
    password TEXT
);

