jdbc:h2:./var/osmgraz
org.h2.Driver
sa
graz
CREATE TABLE IF NOT EXISTS TRANSPORTS AS SELECT * FROM CSVREAD('./out/Graz_transports_filtered.csv');
SELECT * FROM TRANSPORTS;
exit
