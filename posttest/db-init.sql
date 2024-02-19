

CREATE TABLE lottery
(
    id          SERIAL PRIMARY KEY,
    ticket      VARCHAR(6) UNIQUE NOT NULL,
    price       INT
);

-- Initial data
INSERT INTO lottery(ticket, price)
VALUES ('000001', 80);
INSERT INTO lottery(ticket, price)
VALUES ('000002', 80);
INSERT INTO lottery(ticket, price)
VALUES ('000003', 80);
INSERT INTO lottery(ticket, price)
VALUES ('000004', 80);
INSERT INTO lottery(ticket, price)
VALUES ('000005', 80);
INSERT INTO lottery(ticket, price)
VALUES ('123456', 80);
