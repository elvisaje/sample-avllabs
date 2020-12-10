DROP TABLE IF EXISTS Person;
DROP TABLE IF EXISTS Address;

CREATE TABLE Address (
    id BIGINT NOT NULL,
    street VARCHAR(500) NOT NULL,
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    postal_code VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,    
    PRIMARY KEY (id)
);

CREATE TABLE Person (
    id BIGINT NOT NULL,
    name VARCHAR(500) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) NOT NULL,
    id_address BIGINT NULL UNIQUE,
    PRIMARY KEY (id),
    CONSTRAINT fk_person_address_id FOREIGN KEY (id_address) REFERENCES Address(id)
);