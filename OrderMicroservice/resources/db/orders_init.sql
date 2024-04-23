DROP TABLE IF EXISTS ORDERS;

CREATE TABLE ORDERS
(
    orderid       SERIAL PRIMARY KEY,
    username      TEXT      NOT NULL,
    items         JSONB     NOT NULL,
    address       TEXT      NOT NULL,
    time_of_order TIMESTAMP NOT NULL,
    price         BIGINT    NOT NULL
);

INSERT INTO ORDERS (username, items, address, time_of_order, price)
VALUES ('john.doe', '{
  "1": 2,
  "2": 1
}', 'banashankari', '2024-04-06 10:30:25', 250);