
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
    ticket      VARCHAR(6) UNIQUE NOT NULL,
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
    userId      VARCHAR(10),
    ticketId    INT
);

-- Initial data
INSERT INTO user_ticket(userId, ticketId)
VALUES ('0000000001', 123456);
