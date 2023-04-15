CREATE TABLE IF NOT EXISTS health_bits
(
    id integer NOT NULL,
    category VARCHAR(255)  NOT NULL,
    description text  NOT NULL,
    picture_url VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS health_events
(
    id integer NOT NULL ,
    title VARCHAR(255) NOT NULL,
    description text NOT NULL,
    picture_url VARCHAR(255) NOT NULL,
    learn_more_url VARCHAR(255) NOT NULL,
    start_date date NOT NULL,
    end_date date NOT NULL
);