jdbc:h2:./var/osmgraz
org.h2.Driver
sa
graz
CREATE TABLE IF NOT EXISTS `VENUES` AS SELECT * FROM CSVREAD('./out/Graz_venues_filtered.csv', null, 'UTF-8', chr(9));
SELECT * FROM `VENUES`;
exit
