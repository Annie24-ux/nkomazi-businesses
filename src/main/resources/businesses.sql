CREATE TABLE IF NOT EXISTS businesses (

id INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
name VARCHAR(255),
description VARCHAR(255),
location VARCHAR(255),
contact VARCHAR(255),
owner VARCHAR(255)

);