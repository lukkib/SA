/**
 * $File$
 * $Date$
 * $Revision$
 */

package at.tugraz.sa.io;

import static at.tugraz.sa.model.generated.Tables.*;
import static org.jooq.impl.DSL.*;
import org.jooq.*;
import org.jooq.impl.*;
import java.sql.*;
import java.util.function.*;

public class DatabaseManager implements AutoCloseable {

  // TODO: make these runtime args?
  private static final String url = "jdbc:h2:file:./var/osmgraz";
  private static final String username = "sa";
  private static final String password = "graz";

  private final Connection connection;
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, username, password);
  }

  public DatabaseManager() throws SQLException {
    this.connection = getConnection();
  }

  @Override
  public void close() throws SQLException {
    connection.close();
  }

  // TODO: Do we want static connection manager?
  // TODO: Extend this (transactions etc?)
  // TODO: Do we want to create new context here or use no-args lambda?
  public <R> R execute(Function<DSLContext,R> fn) {
    R res = null;
    try {
      DSLContext context = DSL.using(this.connection, SQLDialect.H2);
      res = fn.apply(context);
    }
    catch (Exception e) {
      // TODO: proper exc. handling
      e.printStackTrace();
    }
    return res;
  }

}
