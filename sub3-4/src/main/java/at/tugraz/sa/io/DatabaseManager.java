package at.tugraz.sa.io;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.function.Function;

public class DatabaseManager implements AutoCloseable
{
  private static final String url = "jdbc:h2:file:./var/osmgraz";
  private static final String username = "sa";
  private static final String password = "graz";

  private final Connection connection;
  public static Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection(url, username, password);
  }

  public DatabaseManager() throws SQLException
  {
    this.connection = getConnection();
  }

  @Override
  public void close() throws SQLException
  {
    connection.close();
  }

  public <R> R execute(Function<DSLContext,R> fn)
  {
    R res = null;
    try
    {
      DSLContext context = DSL.using(this.connection, SQLDialect.H2);
      res = fn.apply(context);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    return res;
  }
}
