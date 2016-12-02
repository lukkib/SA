package at.tugraz.sa.controller;

import at.tugraz.sa.io.DatabaseManager;
import at.tugraz.sa.model.generated.tables.records.StopsRecord;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.List;
import java.sql.SQLException;

import static at.tugraz.sa.model.generated.Tables.STOPS;

public class StopController
{
  public List<StopsRecord> findStops(String name) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
//    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
//    return context.selectFrom(STOPS).where(STOPS.NAME.like("%" + name + "%"))
//      .fetch();
    return dbm.execute((context) ->
    {
      return context.selectFrom(STOPS).where(STOPS.NAME.like("%" + name + "%"))
        .fetch();
    });
  }

  /**
   * Finds a stop id by a given name.
   *
   * @param name      the name of the stop
   * @return id       the id of the stop
   * @return -1       if no stop was found
   * @throws SQLException
   */
  public int findStopIdByName(String name) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    StopsRecord stop = context.selectFrom(STOPS).where(STOPS.NAME.equal(name)).fetchAny();

    if (stop.field(STOPS.NAME) != null)
    {
      dbm.close();
      return Integer.parseInt(stop.get_40id());
    }
    // ELSE no stop was found
    dbm.close();
    return -1;
  }

  public List<StopsRecord> filterLessThanLat(String lat) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    return dbm.execute((context) ->
    {
      return context.selectFrom(STOPS).where(STOPS._40LAT.lessThan(lat))
        .fetch();
    });
  }

  public List<StopsRecord> filterGreaterThanLat(String lat) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    return dbm.execute((context) ->
    {
      return context.selectFrom(STOPS).where(STOPS._40LAT.greaterThan(lat))
        .fetch();
    });
  }

  public List<StopsRecord> filterLessThanLon(String lon) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    return dbm.execute((context) ->
    {
      return context.selectFrom(STOPS).where(STOPS._40LON.lessThan(lon))
        .fetch();
    });
  }

  public List<StopsRecord> filterGreaterThanLon(String lon) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    return dbm.execute((context) ->
    {
      return context.selectFrom(STOPS).where(STOPS._40LON.greaterThan(lon))
        .fetch();
    });
  }
}