CONCAT('firstStr', 'secStr');
CONCAT_WS('sep', 'firstStr', 'secStr');

SUBSTRING('str', st_index, cnt) # starts from 1
SUBSTR(); # alias

REPLACE('strToReplace', 'what', 'with');
REPLACE('maikaTi', 'maika', 'bashta');

REVERSE('str');

###
CHAR() // ASCII code
CHAR_LENGTH()
UPPER()
LOWER()
REPEAT(str, cnt)