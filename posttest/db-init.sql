
--CREATE TABLE lottery (
--    id SERIAL PRIMARY KEY,
--    ticket VARCHAR(255) NOT NULL,
--    price NUMERIC NOT NULL,
--    amount INTEGER NOT NULL
--);
--
--CREATE TABLE user_ticket (
--    id SERIAL PRIMARY KEY,
--    userId INTEGER,
--    ticketId INTEGER
----    FOREIGN KEY (userId) REFERENCES users(id),
----    FOREIGN KEY (ticketId) REFERENCES lottery(id)
--);

-- lottery Table
CREATE TABLE lottery
(
    id          SERIAL PRIMARY KEY,
    ticket      VARCHAR(6),
    price       INT,
    amount      INT
);

-- Initial data
INSERT INTO lottery(ticket, price, amount)
VALUES ('000001', 80, 1);
INSERT INTO lottery(ticket, price, amount)
VALUES ('000002', 80, 1);
INSERT INTO lottery(ticket, price, amount)
VALUES ('000003', 80, 1);
INSERT INTO lottery(ticket, price, amount)
VALUES ('000004', 80, 1);
INSERT INTO lottery(ticket, price, amount)
VALUES ('000005', 80, 1);
INSERT INTO lottery(ticket, price, amount)
VALUES ('123456', 80, 1);

-- user_ticket Table
CREATE TABLE user_ticket
(
    id          SERIAL PRIMARY KEY,
    user_id      VARCHAR(10) NOT NULL,
    ticket_id    VARCHAR(6) NOT NULL,
    price       INT,
    amount      INT
);

-- Initial data
INSERT INTO user_ticket(user_id, ticket_id, price, amount)
VALUES ('0000000001', '000001', 80, 1);
INSERT INTO user_ticket(user_id, ticket_id, price, amount)
VALUES ('0000000002', '000002', 80, 1);
