mkdir -p out; ./osmfilter austria-latest.osm --keep="railway=tram_stop" --keep="highway=bus_stop" -o=out/transports.osm &&
./osmconvert out/transports.osm --all-to-nodes --csv="@id @lon @lat name" --csv-headline -B=Graz.poly -o=out/Graz_transports.csv &&
awk '$4!=""' out/Graz_transports.csv > out/Graz_transports_filtered.csv &&
mkdir -p var; java -cp db/h2*.jar org.h2.tools.Shell < db/create_transports.sql
