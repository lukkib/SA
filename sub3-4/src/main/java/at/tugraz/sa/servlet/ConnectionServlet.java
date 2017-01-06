package at.tugraz.sa.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import at.tugraz.sa.Filter;
import at.tugraz.sa.controller.DataHandler;
import at.tugraz.sa.controller.Planer;
import at.tugraz.sa.controller.StopController;
import at.tugraz.sa.model.generated.tables.records.StopsRecord;

/**
 * Servlet implementation class Filter
 */
@WebServlet(name = "ConnectionServlet", urlPatterns = { "/connection" })
public class ConnectionServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public ConnectionServlet()
  {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    // TODO Auto-generated method stub
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    String start = request.getParameter("start");
    String destination = request.getParameter("destination");

    System.out.println("Start: " + start);
    System.out.println("Destination: " + destination);

    try
    {
      List<String> results= new ArrayList<String>();
      StopController stopController = new StopController();
      DataHandler handler = new DataHandler();

      String list = new String();

      if (start.isEmpty() || destination.isEmpty())
      {
  //      results.add("Enter Start and Target");
  //      ObservableList<String> items = FXCollections.observableArrayList();
  //      items.add(results.get(0));
  //      routes.setItems(items);
        request.getRequestDispatcher("connectionHome.jsp").include(request, response);
        return;
      }
      else
      {
        Planer planer = new Planer(stopController.findStopIdByName(start),
          stopController.findStopIdByName(destination));
        results = planer.findConnections(handler);
        for (int i = 0; i < results.size(); i++)
        {
          list = addElement(list, handler.getRoutebyID(results.get(i)));
        }
        request.setAttribute("results", results.size());
        request.setAttribute("list", list);
        request.getRequestDispatcher("connection.jsp").include(request, response);
        return;
      }
    }
      catch (SQLException e)
    {
      e.printStackTrace();
    }
      catch (Exception e) // TODO Add custom exception
    {
      System.err.println("TODO: Throw custom exception or handle invalid " +
        "mode!");
    }
    request.getRequestDispatcher("connectionHome.jsp").include(request, response);
    return;
  }

  private String addElement(String list, String element)
  {
    if (!list.isEmpty())
    {
      list = list.concat("\n");
    }
    list = list.concat("<option>");
    list = list.concat(element);
    list = list.concat("</option>");
    return list;
  }
}
