--liquibase formatted sql
--changeset Andri:1-table-role-create
CREATE TABLE roles (
    id BIGINT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB;

--rollback DROP TABLE roles;