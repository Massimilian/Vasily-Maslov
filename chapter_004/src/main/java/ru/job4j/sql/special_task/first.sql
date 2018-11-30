/*
Задание:
Создать таблицу из двух столбцов (id и name).
Заполнить её произвольными, в т.ч. повторяющимися значениями.
*/


CREATE TABLE first_table (
id SERIAL PRIMARY KEY,
name TEXT
)

INSERT INTO first_table(name) VALUES ('b')

INSERT INTO first_table(name) VALUES ('a')

INSERT INTO first_table(name) VALUES ('b')

INSERT INTO first_table(name) VALUES ('a')

INSERT INTO first_table(name) VALUES ('c')

INSERT INTO first_table(name) VALUES ('d')

INSERT INTO first_table(name) VALUES ('c')

INSERT INTO first_table(name) VALUES ('a')

INSERT INTO first_table(name) VALUES ('b')

INSERT INTO first_table(name) VALUES ('a')

INSERT INTO first_table(name) VALUES ('b')