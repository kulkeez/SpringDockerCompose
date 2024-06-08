CREATE TABLE IF NOT EXISTS EMPLOYEE 
(
	ID int NOT NULL PRIMARY KEY,
	FIRST_NAME varchar(255),
	LAST_NAME varchar(255),
	ADDRESS varchar(255)
);

INSERT INTO EMPLOYEE VALUES (1, 'James', 'Gosling', 'Canada');

INSERT INTO EMPLOYEE VALUES (2, 'Donald', 'Knuth', 'USA');

INSERT INTO EMPLOYEE VALUES (3, 'Linus', 'Torvalds', 'Finland');

INSERT INTO EMPLOYEE VALUES (4, 'Dennis', 'Ritchie', 'USA');