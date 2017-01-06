mkdir -p out; osmfilter austria-latest.osm --keep="amenity=bar" --keep="amenity=biergarten" --keep="amenity=cafe" --keep="amenity=fast-food" --keep="amenity=pub" --keep="amenity=restaurant" -o=out/venues.osm &&
osmconvert out/venues.osm -B=Graz.poly -o=out/Graz_venues.osm &&
osmconvert out/Graz_venues.osm --all-to-nodes --csv="@id @lon @lat name website" --csv-headline -o=out/Graz_venues.csv &&
awk '$4!=""' out/Graz_venues.csv > out/Graz_venues_filtered.csv &&
mkdir -p var; java -cp db/h2*.jar org.h2.tools.Shell < db/create_venues.sql
