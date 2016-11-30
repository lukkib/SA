java -cp db/h2*.jar org.h2.tools.Shell < db/create_transports.sql &&
java -cp db/h2*.jar org.h2.tools.Shell < db/create_venues.sql &&
echo Successfully updated database!
