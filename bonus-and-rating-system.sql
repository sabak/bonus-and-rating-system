DROP DATABASE bonus_and_rating_system;
create DATABASE bonus_and_rating_system;
use bonus_and_rating_system;

create table position (
  position_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  position_description VARCHAR(20)
);

INSERT INTO position (position_description) VALUES ('core developer');
INSERT INTO position (position_description) VALUES ('db administrator');
INSERT INTO position (position_description) VALUES ('contractor');
INSERT INTO position (position_description) VALUES ('Project Manager');


create table department (
  department_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  department_name VARCHAR(20)
);

INSERT INTO department (department_name) VALUES ('IT');
INSERT INTO department (department_name) VALUES ('Money Market');


create table employee (
  employee_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name VARCHAR(20),
  surname VARCHAR(20),
  date_of_birth DATE,
  sex VARCHAR(1),
  pid VARCHAR(11),
  picture BLOB,
  position_id INT,
  salary INT,
  department_id INT,
  manager_id INT,

  FOREIGN KEY (position_id) REFERENCES position (position_id),
  FOREIGN KEY (department_id) REFERENCES department (department_id),
  FOREIGN KEY (manager_id) REFERENCES employee (employee_id)
);

INSERT INTO employee (name, surname, date_of_birth, sex, pid,
                      position_id, salary, department_id)
VALUES ('saba', 'kharabadze', '1994-07-19', 'M', '01008051179', 1, 5000, 1);

INSERT INTO employee (name, surname, date_of_birth, sex, pid,
                      position_id, salary, department_id)
VALUES ('beso', 'gagua', '1975-01-04', 'M', '01008011234', 2, 20000, 1);

INSERT INTO employee (name, surname, date_of_birth, sex, pid,
                      position_id, salary, department_id)
VALUES ('paata', 'makharadze', '1964-03-09', 'M', '01138051179', 1, 15000, 2);

INSERT INTO employee (name, surname, date_of_birth, sex, pid,
                      position_id, salary, department_id)
VALUES ('nino', 'kapanadze', '1984-11-29', 'F', '01013567324', 4, 3000, 1);


create table contact (
  contact_id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  contact_type VARCHAR(20),
  contact_details VARCHAR(100),
  employee_id INT NOT NULL,

  FOREIGN KEY (employee_id) REFERENCES employee (employee_id)
);

INSERT INTO contact (contact_type, contact_details, employee_id)
VALUES ('mail', 'skhar12@freeuni.edu.ge', 1);

INSERT INTO contact (contact_type, contact_details, employee_id)
VALUES ('mobile', '598110042', 1);

INSERT INTO contact (contact_type, contact_details, employee_id)
VALUES ('mail', 'bgagua@bog.ge', 2);

INSERT INTO contact (contact_type, contact_details, employee_id)
VALUES ('mobile', '558435612', 3);


create table document_info(
  document_info_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  document_type VARCHAR(20),
  document_number VARCHAR(20),
  issue_date DATE,
  issuing_authority VARCHAR(20),
  valid_thru DATE,
  employee_id INT NOT NULL,

  FOREIGN KEY (employee_id) REFERENCES employee (employee_id)
);

INSERT INTO document_info (document_type, document_number, issue_date, issuing_authority, valid_thru, employee_id)
VALUES ('id card', '42424242', '2012-03-01', 'Ministry of justice', '2018-03-01', 1);

INSERT INTO document_info (document_type, document_number, issue_date, issuing_authority, valid_thru, employee_id)
VALUES ('id card', '99999999', '2015-12-12', 'Ministry of justice', '2025-12-12', 2);

INSERT INTO document_info (document_type, document_number, issue_date, issuing_authority, valid_thru, employee_id)
VALUES ('id card', '07070707', '2002-03-01', 'Ministry of justice', '2022-03-01', 3);


create table address (
  address_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
  address_details VARCHAR(200),
  employee_id INT NOT NULL,

  FOREIGN KEY (employee_id) REFERENCES employee (employee_id)
);

INSERT INTO address (address_details, employee_id)
VALUES ('tbilisi, nutsubidzis IV plato', 1);

INSERT INTO address (address_details, employee_id)
VALUES ('tbilisi, chavchavadzis 22', 2);

INSERT INTO address (address_details, employee_id)
VALUES ('tbilisi, bagebis dasakhleba', 3);


create table project (
  project_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  project_name VARCHAR(20),
  start_date DATE,
  end_date DATE,
  customer VARCHAR(20),
  cost INT,
  bonus INT,
  project_status VARCHAR(20)

);

INSERT INTO project (project_name, start_date, end_date, customer, cost, bonus, project_status)
VALUES ('ibank', '2014-03-03', '2014-03-03', 'management', 1000000, 100000, 'finished');


create table task_types(
  task_type_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  task_description VARCHAR(20)
);

INSERT INTO task_types (task_description) VALUES ('business analyses');
INSERT INTO task_types (task_description) VALUES ('system analyses');
INSERT INTO task_types (task_description) VALUES ('development');
INSERT INTO task_types (task_description) VALUES ('quality control');
INSERT INTO task_types (task_description) VALUES ('project management');


create table task (
  task_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  task_type INT,
  employee_id INT NOT NULL,
  planned_time INT,
  time_spent INT,
  status VARCHAR(20),
  project_id INT NOT NULL,

  FOREIGN KEY (project_id) REFERENCES project (project_id),
  FOREIGN KEY (task_type) REFERENCES task_types (task_type_id)
);

INSERT INTO task (employee_id, task_type, planned_time, time_spent, status, project_id)
VALUES (1, 2, 30, 40, 'not done', 1);


create table project_types(
  project_type_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  project_description VARCHAR(50)
);

INSERT INTO project_types (project_description)
VALUES ('internal project');

INSERT INTO project_types (project_description)
VALUES ('external project');

INSERT INTO project_types (project_description)
VALUES ('infrastructural project');

INSERT INTO project_types (project_description)
VALUES ('integrative project');


create table project_employees(
  employee_id INT NOT NULL,
  project_id INT NOT NULL,

  FOREIGN KEY (employee_id) REFERENCES employee (employee_id),
  FOREIGN KEY (project_id) REFERENCES project (project_id)
);

INSERT INTO project_employees (employee_id, project_id) VALUES (1,1);

CREATE TABLE task_percentage(
  project_id INT,
  task_types INT,
  percentage INT,

  FOREIGN KEY (project_id)
  REFERENCES project(project_id),
  FOREIGN KEY (task_types)
  REFERENCES task_types(task_type_id)
);

INSERT INTO task_percentage (project_id, task_types, percentage)
VALUES (1, 1, 50);

INSERT INTO task_percentage (project_id, task_types, percentage)
VALUES (1, 2, 50);


CREATE TABLE user(
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(20) NOT NULL UNIQUE,
  password_hash CHAR(64) NOT NULL,
  user_type VARCHAR(1) NOT NULL,
  employee_id INT
);


INSERT INTO user (username, password_hash, user_type, employee_id)
VALUES ('user', '04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb', 'U', 1);

INSERT INTO user (username, password_hash, user_type)
VALUES ('admin', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', 'A');

SELECT *
FROM user, employee WHERE user.employee_id=employee.employee_id;