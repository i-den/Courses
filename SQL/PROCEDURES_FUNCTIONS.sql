############################################################
# Procedures - cannot invoke in statements, 
#              e.g. SELECT proc, must use CALL proc
############################################################

CREATE DEFINER = { user | CURRENT_USER }
PROCEDURE proc_name()
	BEGIN
		SELECT 'Name:', COUNT(*) 
		FROM mysql.user
	END;


IN parameter passes a value into a procedure.
The procedure might modify the value, but the modification is not visible to the caller when the procedure returns.

OUT parameter passes a value from the procedure back to the caller.
Its initial value is NULL within the procedure, and its value is visible to the caller when the procedure returns.

INOUT parameter is initialized by the caller, can be modified by the procedure,
and any change made by the procedure is visible to the caller when the procedure returns.


############################################################
CREATE DEFINER = `root`@`127.0.0.1`
PROCEDURE `GET_USER_NAME` (INOUT user_name VARCHAR(16),
						   IN 	 user_id   VARCHAR(16))
	BEGIN
		DECLARE uname VARCHAR(16)
		SELECT
			name INTO uname
		FROM 
			USER
		WHERE
			user_id = 'some_id'
		SET user_name = 'Some Name'
	END

############################################################
DELIMITER $$
CREATE DEFINER = `root`@`127.0.0.1`
PROCEDURE `GET_SALARAY` (INOUT no_employees INT
						 IN salary INT)
	BEGIN
		CASE
			WHEN (salary>10000)
				THEN (SELECT
						COUNT(job_id) 
					  INTO
					  	no_employees 
					  FROM
					  	jobs
					  WHERE 
					  	min_salary>10000)

			WHEN (salary<10000)
				THEN (SELECT
						COUNT(job_id) 
					  INTO
					  	no_employees 
					  FROM
					  	jobs
					  WHERE 
					  	min_salary<10000)

			ELSE (SELECT
					COUNT(job_id)
				  INTO
				  	no_employees
				  FROM
				  	jobs
				  WHERE
				  	min_salary=10000)
		END CASE
	END$$

CALL GET_SALARAY(@C, 10001)
SELECT @C; # 2