CREATE TABLE IF NOT EXISTS health_bits (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    category VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    picture BLOB
    );