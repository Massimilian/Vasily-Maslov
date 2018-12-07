/*
Задание:
удалить все предполагаемые дубликаты из таблицы
*/

CREATE TABLE second_table AS (SELECT DISTINCT ft.duplic FROM first_table as ft)
UNION
DROP TABLE first_table
UNION
ALTER TABLE second_table RENAME TO first_table;

DELETE FROM a USING (SELECT MIN(ctid) as ctid, name from a GROUP BY name HAVING COUNT(*) > 1 )
b WHERE a.name = b.name AND a.ctid <> b.ctid;