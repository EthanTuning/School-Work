USE f16tuning_DDL;

CREATE TABLE Category
(
   CatCode   VARCHAR(2),
   CatDesc   VARCHAR(10)
);

CREATE TABLE Employees
(
   Emp_num     INTEGER(5),
   Lastname    VARCHAR(12),
   Firstname   VARCHAR(12),
   Job_class   VARCHAR(4)
);

ALTER TABLE Employees
   ADD COLUMN EmpDate DATE;

ALTER TABLE Employees
   ADD COLUMN EndDate DATE;

ALTER TABLE Employees
   CHANGE COLUMN Job_class Job_class VARCHAR(4);

ALTER TABLE Employees
   DROP COLUMN EndDate;

ALTER TABLE Employees
   RENAME JL_EMPS;