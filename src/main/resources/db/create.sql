SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS departments (
id int PRIMARY KEY auto_increment,
name VARCHAR,
description VARCHAR,
number_of_staff INTEGER
);

CREATE TABLE IF NOT EXISTS news (
id int PRIMARY KEY auto_increment,
content VARCHAR,
writtentby VARCHAR
departmentid INTEGER
);

CREATE TABLE IF NOT EXISTS users (
id int PRIMARY KEY auto_increment,
name VARCHAR,
position VARCHAR
);
CREATE TABLE IF NOT EXISTS users_departments (
id int PRIMARY KEY auto_increment,
departmentid INTEGER,
usersid INTEGER,
);