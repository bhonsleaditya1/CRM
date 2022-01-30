/* DROP DATABASE web_customer_tracker;
drop user springstudent;
CREATE USER springstudent with password 'springstudent';
CREATE DATABASE web_customer_tracker;

\connect web_customer_tracker springstudent; */

DROP TABLE IF EXISTS customer;
CREATE TABLE customer (
    id SERIAL PRIMARY KEY NOT NULL,
    first_name varchar(45) DEFAULT NULL,
    last_name varchar(45) DEFAULT NULL,
    email varchar(45) DEFAULT NULL
);

INSERT INTO customer(first_name, last_name, email) VALUES
   ('David','Adams','david@mail.com'),
   ('John','Doe','john@mail.com'),
   ('Ajay','Rao','ajay@mail.com'),
   ('Mary','Public','mary@mail.com'),
   ('Maxwell','Dixon','max@mail.com');

