#alter table rating add column make text after username;
#truncate table rating;
ALTER TABLE rating DROP id;
ALTER TABLE rating ADD id INT NOT NULL AUTO_INCREMENT FIRST ,
ADD PRIMARY KEY (id);

SET SQL_MODE = '';

INSERT INTO rating (make,model,username) 
SELECT p.make, p.model, u.username FROM users as u, phone as p;
update rating set userRating = (SELECT FLOOR(RAND(43)*(101)));

#alter table rating auto_increment = 2906;
#INSERT INTO rating (username) SELECT username FROM users where id < 41;
#INSERT INTO rating (userRating) SELECT username FROM users;
#INSERT INTO rating SELECT u.username FROM dbms_phone1.users as u;
#INSERT INTO rating SELECT  p.make, p.model FROM dbms_phone1.phone as p;userRatingusername
#INSERT INTO rating (username)
#SELECT FROM users WHERE <condition>;

#

#SET SQL_SAFE_UPDATES=0;
#UPDATE `dbms_phone1`.`phone2`
#SET
#`memory (GB)` = 'mem(GB)';
#SET SQL_SAFE_UPDATES=1;

