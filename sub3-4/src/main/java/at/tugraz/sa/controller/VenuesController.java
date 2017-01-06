package at.tugraz.sa.controller;

import at.tugraz.sa.io.DatabaseManager;
import at.tugraz.sa.model.generated.tables.Venues;
import at.tugraz.sa.model.generated.tables.records.StopsRecord;

import at.tugraz.sa.model.generated.tables.records.VenuesRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import static at.tugraz.sa.model.generated.Tables.STOPS;
import static at.tugraz.sa.model.generated.Tables.VENUES;

public class VenuesController
{
    public ArrayList<Restaurant> inBox(String minLon, String maxLon, String minLat, String maxLat) throws SQLException
    {
        DatabaseManager dbm = new DatabaseManager();
        DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
        Result<VenuesRecord> res = context.selectFrom(VENUES).where(VENUES._40LON.greaterThan(minLon)).and(VENUES._40LON.lessThan(maxLat)).and(VENUES._40LAT.greaterThan(minLat)).and(VENUES._40LON.lessThan(maxLat)).fetch();
        /*
        System.out.println("res.size: " + res.size());
        List<VenuesRecord> sr = new ArrayList<>();
        sr.addAll(res);
        System.out.println("sr.size: " + sr.size());
        return sr;
        */
        ArrayList<Restaurant> venues = new ArrayList<>();
        for (VenuesRecord record: res)
        {
            Restaurant venue = new Restaurant(record.getName());
            venues.add(venue);
        }
        return venues;
    }
}
