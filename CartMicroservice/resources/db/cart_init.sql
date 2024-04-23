DROP TABLE IF EXISTS USERCART;

CREATE TABLE USERCART
(
    username VARCHAR(255) PRIMARY KEY,
    items    JSONB NOT NULL
);

INSERT INTO USERCART (username, items) VALUES
                     ('john.doe', '{"1": 2, "2": 1}');