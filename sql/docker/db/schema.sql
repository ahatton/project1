CREATE DATABASE mds;

GRANT ALL PRIVILEGES ON mds.* TO 'mds'@'%';

USE mds;
CREATE TABLE orders (order_id numeric, price numeric, destination varchar(255), customer_id varchar(255));
INSERT INTO orders VALUES (23, 800, 'Cork', 'ebz');
INSERT INTO orders VALUES (24, 200, 'Dublin', 'xyz');
INSERT INTO orders VALUES (26, 150, 'Mayo', 'ebz');
INSERT INTO orders VALUES (33, 700, 'Cork', 'cbc');
INSERT INTO orders VALUES (34, 25, 'Cork', 'cbc');
INSERT INTO orders VALUES (35, 50, 'Limerick', 'xyz');