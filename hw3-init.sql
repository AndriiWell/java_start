CREATE SCHEMA IF NOT EXISTS `users_storage`;

USE `users_storage`;

CREATE TABLE IF NOT EXISTS users
(
    id    BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(50),
    phone VARCHAR(20),
    password VARCHAR(20)
);

GRANT ALL PRIVILEGES ON users_storage.* TO 'user'@'%';
