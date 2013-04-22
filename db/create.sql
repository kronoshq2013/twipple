DROP TABLE IF EXISTS users;
CREATE TABLE users(usid INT PRIMARY KEY, name VARCHAR(255), password VARCHAR(255));
INSERT INTO users VALUES ( 0, 'test', 'test');