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
CASE
	WHEN col0 BETWEEN 0 AND 1 THEN 'STRING1'
	WHEN col1 = 2 			  THEN 'STRING2'
							  ELSE 'STRING3'
FROM
	`table`
INNER JOIN
	`table2`
	ON tabl1.id = table2.t1_id
WHERE
	clause LIKE 'str%'
AND
	col LIKE '___' # len
OR
	col3 in ('1', '2', '3')
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