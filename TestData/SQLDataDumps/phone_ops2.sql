
DELIMITER $$
CREATE TRIGGER after_rating_update 
    AFTER UPDATE ON rating
    FOR EACH ROW 
BEGIN
	update phone p join
       (select model, avg(userRating) as avgscore
        from rating r
        group by model
       ) r
       on p.model = r.model
    set p.avgRating = r.avgscore;
END$$
DELIMITER ;


