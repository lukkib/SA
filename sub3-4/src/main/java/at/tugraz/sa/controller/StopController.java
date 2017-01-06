package at.tugraz.sa.controller;

import at.tugraz.sa.io.DatabaseManager;
import at.tugraz.sa.model.generated.tables.records.StopsRecord;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import static at.tugraz.sa.model.generated.Tables.STOPS;

public class StopController
{
  public List<StopsRecord> findStops(String name) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    return dbm.execute((context) ->
    {
        return context.selectFrom(STOPS).where(STOPS.NAME.contains(name)).fetch();
    });
  }

  public String findStopLonByName(String name) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    StopsRecord stop = context.selectFrom(STOPS).where(STOPS.NAME.equal(name)).fetchAny();

    if (stop != null)
    {
      dbm.close();
      return stop.get_40lon();
    }
    // ELSE no stop was found
    dbm.close();
    return null;
  }

  public String findStopLatByName(String name) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    StopsRecord stop = context.selectFrom(STOPS).where(STOPS.NAME.equal(name)).fetchAny();

    if (stop != null)
    {
      dbm.close();
      return stop.get_40lat();
    }
    // ELSE no stop was found
    dbm.close();
    return null;
  }

  /**
   * Finds a stop id by a given name.
   *
   * @param name      the name of the stop
   * @return id       the id of the stop
   * @return null     if no stop was found
   * @throws SQLException
   */
  public String findStopIdByName(String name) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    StopsRecord stop = context.selectFrom(STOPS).where(STOPS.NAME.equal(name)).fetchAny();

    if (stop != null)
    {
      dbm.close();
      return stop.get_40id();
    }
    // ELSE no stop was found
    dbm.close();
    return null;
  }

  public List<StopsRecord> filterLessThanLat(String lat) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    Result<StopsRecord> res = context.selectFrom(STOPS).where(STOPS._40LAT.lessThan(lat))
        .fetch();

    List<StopsRecord> sr = new ArrayList<>();
    sr.addAll(res);
    return sr;
  }

  public List<StopsRecord> filterGreaterThanLat(String lat) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    Result<StopsRecord> res = context.selectFrom(STOPS).where(STOPS._40LAT.greaterThan(lat))
      .fetch();

    List<StopsRecord> sr = new ArrayList<>();
    sr.addAll(res);
    return sr;
  }

  public List<StopsRecord> filterLessThanLon(String lon) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    Result<StopsRecord> res = context.selectFrom(STOPS).where(STOPS._40LON.lessThan(lon))
      .fetch();

    List<StopsRecord> sr = new ArrayList<>();
    sr.addAll(res);
    return sr;
  }

  public List<StopsRecord> filterGreaterThanLon(String lon) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    Result<StopsRecord> res = context.selectFrom(STOPS).where(STOPS._40LON.greaterThan(lon))
      .fetch();

    List<StopsRecord> sr = new ArrayList<>();
    sr.addAll(res);
    return sr;
  }
}
