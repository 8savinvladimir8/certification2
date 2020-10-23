CREATE TABLE address
(
    id          BIGSERIAL primary key,
    city        VARCHAR(30),
    street      VARCHAR(30),
    home_number VARCHAR(11)
);

INSERT into address (city, street, home_number)
VALUES ('Innopolis', 'Univercity', '79121234567');