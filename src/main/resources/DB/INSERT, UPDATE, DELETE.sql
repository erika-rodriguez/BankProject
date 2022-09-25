USE bank;
INSERT INTO branch (id_branch, city) VALUES (01,'New York');
INSERT INTO branch (id_branch, city) VALUES (02,'Chicago');
INSERT INTO branch (id_branch, city) VALUES (03,'San Diego');
INSERT INTO branch (id_branch, city) VALUES (04,'Boston'); 
INSERT INTO branch (id_branch, city) VALUES (5, 'Houston');
INSERT INTO branch (id_branch, city) VALUES (6, 'Paris');
INSERT INTO branch (id_branch, city) VALUES (7, 'Boulogne sur Mer');
INSERT INTO branch (id_branch, city) VALUES (8, 'Marsella');
INSERT INTO branch (id_branch, city) VALUES (9, 'Lille');
INSERT INTO branch (id_branch, city) VALUES (10, 'Toulouse');
INSERT INTO branch (id_branch, city) VALUES (11, 'Montpellier');
INSERT INTO branch (id_branch, city) VALUES (12, 'Colmar');
INSERT INTO branch (id_branch, city) VALUES (13, 'Burdeos');
INSERT INTO branch (id_branch, city) VALUES (14, 'Nize');
INSERT INTO branch (id_branch, city) VALUES (15, 'Lyon');


UPDATE branch SET city='Phoenix' WHERE city='Paris';
UPDATE branch SET city='Denver' WHERE city='Boulogne sur Mer';
UPDATE branch SET city='Dallas' WHERE city='Marsella';
UPDATE branch SET city='Detroit' WHERE city='Lille';
UPDATE branch SET city='Washington' WHERE city='Toulouse';
UPDATE branch SET city='San Antonio' WHERE city='Montpellier';
UPDATE branch SET city='Seattle' WHERE city='Colmar';
UPDATE branch SET city='Austin' WHERE city='Burdeos';
UPDATE branch SET city='San Francisco' WHERE city='Nize';
UPDATE branch SET city='Nashville' WHERE city='Lyon';

DELETE FROM branch WHERE name='Phoenix';
DELETE FROM branch WHERE name='Denver';
DELETE FROM branch WHERE name='Dallas';
DELETE FROM branch WHERE name='Detroit';
DELETE FROM branch WHERE name='Washington';
DELETE FROM branch WHERE name='San Antonio';
DELETE FROM branch WHERE name='Austin';
DELETE FROM branch WHERE name='Dallas';
DELETE FROM branch WHERE name='San Francisco';
DELETE FROM branch WHERE name='Nashville';