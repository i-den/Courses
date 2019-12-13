##################### CREATE
INSERT INTO 
	`table` (col1, col2)
VALUES 
	(v1, v2),
	(v3, v4)
	(v5, DEFAULT);

##################### READ
SELECT DISTINCT
	(col1, col2)
FROM
	`table`
INNER JOIN
	`table2`
WHERE
	clause LIKE 'str%'
AND
	col LIKE '___' # len
ORDER BY
	cmp_col DESC, cmp_col_2
LIMIT 0,1;


##################### UPDATE
UPDATE 
	`table`
SET
	`col` = 'val'
WHERE
	clause;

##################### DELET this
DELETE FROM `table`
WHERE clause;