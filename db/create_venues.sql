jdbc:h2:./var/osmgraz
org.h2.Driver
sa
graz
CREATE TABLE IF NOT EXISTS VENUES AS SELECT * FROM CSVREAD('./out/Graz_venues_filtered.csv');
SELECT * FROM VENUES;
exit
