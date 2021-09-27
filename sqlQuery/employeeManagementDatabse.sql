
create database dipesh_employee_management_system;

-- Login table
create table login(
firstname varchar(50) ,
lastname varchar(50),
email varchar(50),
username varchar(50)not null,
password varchar(15)not null,
constraint pk_username primary key(username)
);

-- Employee Table
create table employee(
  name varchar(25),
 fname varchar(30),
 age varchar(10),
 dob varchar(20),
 address varchar(50), 
 phone varchar(20), 
 email varchar(30), 
 education varchar(15), 
 post varchar(15), 
 ctzn_no varchar(20), 
 emp_id varchar(10),
 constraint pk_username primary key(emp_id)
 );

-- Select Query to view data
select * from employee;
select * from login;