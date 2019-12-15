CREATE VIEW CUSTOMER_FULL_NAME
AS
	SELECT
		CONCAT(first_name, ' ', last_name)
	FROM
		customers

# Calling
SELECT * FROM CUSTOMER_FULL_NAME;