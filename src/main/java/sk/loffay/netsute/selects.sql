-- Pavol Loffay, p.loffay@gmail.com
-- NetSuite interview 2016
-- mysql --version
-- mysql  Ver 14.14 Distrib 5.7.12, for Linux (x86_64) using  EditLine wrapper

-- SQL notes
-- mysql -u <user> -p
-- source selects.sql

CREATE database netsuite;
use netsuite;

CREATE TABLE employees (
    empid INTEGER NOT NULL,
    name VARCHAR(20) NOT NULL,
    supervisor INTEGER ,
    location VARCHAR(20) NOT NULL,
    salary INTEGER ,
    --
    CONSTRAINT pk_employees PRIMARY KEY (empid)
);

CREATE TABLE bonus (
    empid INTEGER NOT NULL,
    nbonus INTEGER NOT NULL
);

INSERT INTO employees
    VALUES(34, 'Amy',  null , 'NY', '110000');
INSERT INTO employees
    VALUES(17, 'Ben', '34', 'TN', '75000');
INSERT INTO employees
    VALUES(5, 'Chris', '34', 'TN', '80000');
INSERT INTO employees
    VALUES(10, 'Don', '5', 'HI', '100000');

INSERT INTO bonus
    VALUES(17, 500);
INSERT INTO bonus
    VALUES(10, 2000);
INSERT INTO bonus
    VALUES(34, 5000);

-- QUESTION 2 A
-- Write a SQL statement to return the employee's name, supervisor's name and
-- bonus of everyone who got a bonus greater than 1000

SELECT e.name, super.name AS supervisor, b.nbonus
    FROM employees e LEFT JOIN employees super ON e.supervisor=super.empid, bonus b
    WHERE e.empid=b.empid
      AND b.nbonus > 1000;

-- QUESTION 2 B
-- Write a SQL statement to list the highest paid employee in each location.
-- a Ranking should be based on salary plus bonus.  Output should include employee
-- name, salary, bonus, and total pay (salary plus bonus).

SELECT e.name, e.salary, b.nbonus AS bonus, SUM(e.salary+b.nbonus) AS TotalPay
    FROM employees e, bonus b
    WHERE e.empid=b.empid
      AND e.salary+b.nbonus=(
        SELECT MAX(e2.salary+b2.nbonus)
         FROM employees e2, bonus b2
         WHERE e.location=e2.location AND e2.empid=b2.empid
      )
      GROUP BY e.empid, e.salary, b.nbonus;

-- QUESTION 2 C
-- Given a NEW_SUPERVISOR table (columns: EMPID, SUPERVISOR), write an update
-- statement that updates the supervisor of each employee with a new supervisor.
-- The NEW_SUPERVISOR table is an incremental update, so employees not listed in
-- the table must retain their existing supervisor.

CREATE TABLE new_supervisor (
    empid INTEGER NOT NULL,
    supervisor INTEGER NOT NULL
);
INSERT INTO new_supervisor
    VALUES(17, 5);
INSERT INTO new_supervisor
    VALUES(5, 10);

UPDATE
  employees e,
  new_supervisor nSuperVisor
SET
  e.supervisor=nSuperVisor.supervisor
WHERE
  e.empid=nSuperVisor.empid;

SELECT *
FROM employees;

-- clean up
DROP database netsuite;
