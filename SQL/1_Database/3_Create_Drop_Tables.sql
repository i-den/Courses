# Creating Table
CREATE TABLE [IF NOT EXISTS] `table_name` (
    id              INT             AUTO_INCREMENT PRIMARY KEY,
    first_name      VARCHAR(255),
    last_name       VARCHAR(255)    NOT NULL DEFAULT 'unnamed',
    created         TIMESTAMP       DEFAULT CURRENT_TIMESTAMP,
    updated         TIMESTAMP       DEFAULT CURRENT_TIMESTAMP   ON UPDATE CURRENT_TIMESTAMP
) ENGINE=INNODB;

# Dropping Table
DROP TABLE `table_name`;

# Truncate - Delete All Entries in a Table
TRUNCATE [TABLE] `table_name`;