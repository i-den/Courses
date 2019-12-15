CREATE TRIGGER trigger_name 
    trigger_time trigger_event ON table_name FOR EACH ROW
    BEGIN
    ...
    END;

 trigger_time 	BEFORE / AFTER
 trigger_event	INSERT / DELETE / UPDATE 

 OLD
 NEW