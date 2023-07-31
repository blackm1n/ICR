CREATE DATABASE IF NOT EXISTS друзьячеловека;

USE друзьячеловека;

DROP TABLE IF EXISTS иерархия;
CREATE TABLE иерархия
(
	category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(45) NOT NULL,
    parent INT DEFAULT NULL
);

INSERT INTO иерархия(name, parent)
VALUES ('домашниеживотные',NULL),('вьючныеживотные',NULL),('собаки',1),
       ('кошки',1),('хомяки',1),('лошади',2),('верблюды',2),('ослы',2);
    
DROP TABLE IF EXISTS домашниеживотные;
CREATE TABLE домашниеживотные
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL
);

DROP TABLE IF EXISTS вьючныеживотные;
CREATE TABLE вьючныеживотные
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL
);

DROP TABLE IF EXISTS собаки;
CREATE TABLE собаки
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL
);

DROP TABLE IF EXISTS кошки;
CREATE TABLE кошки
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL
);

DROP TABLE IF EXISTS хомяки;
CREATE TABLE хомяки
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL
);

DROP TABLE IF EXISTS лошади;
CREATE TABLE лошади
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL
);

DROP TABLE IF EXISTS верблюды;
CREATE TABLE верблюды
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL
);

DROP TABLE IF EXISTS ослы;
CREATE TABLE ослы
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL
);

INSERT INTO кошки
VALUES ("Albert", "Вставать на задние лапки",  "2020-02-16"), ("Luna", "Круг на месте", "2021-06-13");

INSERT INTO собаки
VALUES ("Otto", "Дать пять", "2018-08-18");

INSERT INTO хомяки
VALUES ("Tucker", "Переворот", "2022-06-14");

INSERT INTO лошади
VALUES ("Gulliver", "Прыжок через кольцо", "2016-11-09"), ("Krystal", "Быстрый бег", "2022-06-19");

INSERT INTO верблюды
VALUES ("Nasir", "Перевоз людей", "2016-09-29");

INSERT INTO ослы
VALUES ("Tex", "Перевоз грузов", "2018-12-26");

DROP TABLE верблюды;
DELETE FROM иерархия WHERE name = "верблюды";

INSERT INTO лошади
SELECT * FROM ослы;

DROP TABLE IF EXISTS лошадиослы;
RENAME TABLE лошади TO лошадиослы;

UPDATE иерархия
SET name = "лошадиослы"
WHERE name = "лошади";

DROP TABLE ослы;
DELETE FROM иерархия WHERE name IN ("ослы");

DROP TABLE IF EXISTS молодыеживотные;
CREATE TABLE молодыеживотные
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL,
    age INT NOT NULL
);

INSERT INTO молодыеживотные
SELECT *, TIMESTAMPDIFF(MONTH, dob, NOW()) AS age FROM кошки WHERE TIMESTAMPDIFF(MONTH, dob, NOW()) < 36 UNION
SELECT *, TIMESTAMPDIFF(MONTH, dob, NOW()) AS age FROM собаки WHERE TIMESTAMPDIFF(MONTH, dob, NOW()) < 36 UNION
SELECT *, TIMESTAMPDIFF(MONTH, dob, NOW()) AS age FROM хомяки WHERE TIMESTAMPDIFF(MONTH, dob, NOW()) < 36 UNION
SELECT *, TIMESTAMPDIFF(MONTH, dob, NOW()) AS age FROM лошадиослы WHERE TIMESTAMPDIFF(MONTH, dob, NOW()) < 36;

DELETE FROM кошки WHERE TIMESTAMPDIFF(MONTH, dob, NOW()) < 36;
DELETE FROM собаки WHERE TIMESTAMPDIFF(MONTH, dob, NOW()) < 36;
DELETE FROM хомяки WHERE TIMESTAMPDIFF(MONTH, dob, NOW()) < 36;
DELETE FROM лошадиослы WHERE TIMESTAMPDIFF(MONTH, dob, NOW()) < 36;

DROP TABLE IF EXISTS всетаблицы;
CREATE TABLE всетаблицы
(
	name VARCHAR(45) NOT NULL,
    commands VARCHAR(45),
    dob DATE NOT NULL,
    age INT,
    oldtable VARCHAR(45) NOT NULL
);

INSERT INTO всетаблицы
SELECT *, NULL, "кошки" as oldtable FROM кошки UNION
SELECT *, NULL, "собаки" as oldtable FROM собаки UNION
SELECT *, NULL, "хомяки" as oldtable FROM хомяки UNION
SELECT *, NULL, "лошадиослы" as oldtable FROM лошадиослы UNION
SELECT *, "молодыеживотные" as oldtable FROM молодыеживотные;

SELECT * FROM всетаблицы;
