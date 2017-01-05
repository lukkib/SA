jdbc:h2:./var/osmgraz
org.h2.Driver
sa
graz
CREATE TABLE IF NOT EXISTS `STOPS` AS SELECT * FROM CSVREAD('./out/Graz_transports_filtered.csv', null, 'UTF-8', chr(9));
SELECT * FROM `STOPS`;
exit
