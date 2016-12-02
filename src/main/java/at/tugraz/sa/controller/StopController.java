package at.tugraz.sa.controller;

import static at.tugraz.sa.model.generated.Tables.*;
import at.tugraz.sa.model.generated.tables.pojos.*;
import at.tugraz.sa.model.generated.tables.records.*;
import static org.jooq.impl.DSL.*;
import org.jooq.*;
import org.jooq.impl.*;
import java.sql.*;
import java.util.function.*;

import at.tugraz.sa.io.DatabaseManager;

public class StopController
{
  /**
   * Finds a stop by a given name.
   *
   * @param name      the name of the stop
   * @return id       the id of the stop
   * @return -1       if no stop was found
   * @throws SQLException
   */
  public int findStop(String name) throws SQLException
  {
    DatabaseManager dbm = new DatabaseManager();
    DSLContext context = DSL.using(dbm.getConnection(), SQLDialect.H2);
    StopsRecord stop = context.selectFrom(STOPS).where(STOPS.NAME.equal(name)).fetchAny();
    System.out.println(stop.getName());

    if (stop.field(STOPS.NAME) != null)
    {
      dbm.close();
      return Integer.parseInt(stop.get_40id());
    }
//    stop.intoList()

    dbm.close();
    return -1;
  }
}
