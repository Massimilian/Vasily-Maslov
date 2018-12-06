/*
Задание:
удалить все предполагаемые дубликаты из таблицы
*/

CREATE TABLE second_table AS (SELECT DISTINCT ft.duplic FROM first_table as ft);  

DROP TABLE first_table;

ALTER TABLE second_table RENAME TO first_table;