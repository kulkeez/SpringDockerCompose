CREATE TABLE IF NOT EXISTS EMPLOYEE 
(
	ID SERIAL PRIMARY KEY,
	FIRST_NAME varchar(255) NOT NULL,
	LAST_NAME varchar(255) NOT NULL,
	GENDER varchar(10),
	COUNTRY varchar(255)
);

TRUNCATE TABLE EMPLOYEE;

INSERT INTO EMPLOYEE (ID, FIRST_NAME, LAST_NAME, GENDER, COUNTRY) 
VALUES 
(1, 'James', 'Gosling', 'Male', 'Canada'),
(2, 'Donald', 'Knuth', 'Male', 'USA'),
(3, 'Linus', 'Torvalds', 'Male', 'Finland'),
(4, 'Dennis', 'Ritchie', 'Male', 'USA');


