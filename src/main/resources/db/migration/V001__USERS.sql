CREATE TABLE account
(
    id              BIGSERIAL primary key,
    first_name      VARCHAR(20),
    last_name       VARCHAR(20),
    email           VARCHAR(255),
    hash_password   VARCHAR(255)
);

INSERT INTO account (first_name, last_name, email, hash_password)
VALUES ('name', 'surname', 'somemail@gmail.com', '$2y$12$0QWSpBcl/Xn46vslYIZT6eYaeSTkG4T82/lOEWrnVbKEH5dxaloTq');