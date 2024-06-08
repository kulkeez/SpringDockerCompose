CREATE TABLE IF NOT EXISTS EMPLOYEE 
(
	ID int NOT NULL PRIMARY KEY,
	FIRST_NAME varchar(255),
	LAST_NAME varchar(255),
	COUNTRY varchar(255)
);

INSERT INTO EMPLOYEE VALUES (1, 'James', 'Gosling', 'Canada');

INSERT INTO EMPLOYEE VALUES (2, 'Donald', 'Knuth', 'USA');

INSERT INTO EMPLOYEE VALUES (3, 'Linus', 'Torvalds', 'Finland');

INSERT INTO EMPLOYEE VALUES (4, 'Dennis', 'Ritchie', 'USA');

INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, GENDER, COUNTRY) 
VALUES (1, 'James', 'Gosling', 'Male', 'USA');

INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, GENDER, COUNTRY) 
VALUES (2, 'Donald', 'Knuth', 'Male', 'UK');

