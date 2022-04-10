CREATE TABLE players
(
    id        BIGINT  PRIMARY KEY,
    name      VARCHAR(50)  NOT NULL,
    last_name VARCHAR(100) NOT NULL

);

CREATE TABLE quiz
(
    id             BIGINT  PRIMARY KEY,
    question       VARCHAR(255) NOT NULL,
    player_answer  VARCHAR(255) NOT NULL,
    correct_answer VARCHAR(255) NOT NULL,
    answer_a       VARCHAR(255),
    answer_b       VARCHAR(255),
    answer_c       VARCHAR(255),
    answer_d       VARCHAR(255),
    answer_e       VARCHAR(255),
    answer_f       VARCHAR(255),
    technology     VARCHAR      NOT NULL,
    player_id      INTEGER      not null,
    FOREIGN KEY (player_id) REFERENCES players (id)
);