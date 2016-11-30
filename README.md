# SA Task 1/2

### Preconditions/Essential Files

  1. `austria-latest.osm` (not contained in the repository, ~10.5 GB disk space needed)
  2. `osmconvert` (installation needed)
  3. `osmfilter` (installation needed)
  4. `Graz.poly`(download `http://kti.tugraz.at/staff/rkern/courses/sa/index.html`)
  5. `routes.csv` (download `http://kti.tugraz.at/staff/rkern/courses/sa/index.html`)

### Setup

  1. Run `./firstcmd.sh` (change mode, if necessary: `chmod +x firstcmd.sh`)
  2. Run `./secondcmd.sh` (change mode, if necessary: `chmod +x secondcmd.sh`)

### Running the client

Issue `gradle run`

### Updating the database

You might want to run this to simply create the db without endless filtering.

  1. Run `./create_select.sh`
