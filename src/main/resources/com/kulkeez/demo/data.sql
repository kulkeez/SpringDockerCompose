CREATE TABLE IF NOT EXISTS EMPLOYEE 
(
	ID int NOT NULL PRIMARY KEY,
	FIRST_NAME varchar(255) NOT NULL,
	LAST_NAME varchar(255) NOT NULL,
	GENDER varchar(10),
	COUNTRY varchar(255)
);

INSERT INTO EMPLOYEE VALUES (1, 'James', 'Gosling', 'Male', 'Canada');

INSERT INTO EMPLOYEE VALUES (2, 'Donald', 'Knuth', 'Male', 'USA');

INSERT INTO EMPLOYEE VALUES (3, 'Linus', 'Torvalds', 'Male'. 'Finland');

INSERT INTO EMPLOYEE VALUES (4, 'Dennis', 'Ritchie', 'Male', 'USA');


