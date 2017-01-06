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
      }
      else
      {
        Planer planer = new Planer(stopController.findStopIdByName(start),
          stopController.findStopIdByName(destination));
        results = planer.findConnections(handler);
        for (int i = 0; i < results.size(); i++)
        {
          list = addElement(list, handler.getRoutebyID(results.get(i)));
          System.out.println(handler.getRoutebyID(results.get(i)));
        }

//        System.out.println(list);

        request.setAttribute("list", list);
  //      ObservableList<String> items = FXCollections.observableArrayList();
  //      for(int i = 0; i < results.size(); i++)
  //      {
  //        items.add(out.get(i));
  //      }
  //      routes.setItems(items);
      }
      request.getRequestDispatcher("connection.jsp").include(request, response);
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
    return;
  }

  private String addElement(String list, String element)
  {
    if (!list.isEmpty())
    {
      list = list.concat("\n");
    }
    list = list.concat("<li>");
    list = list.concat(element);
    list = list.concat("</li>");
    return list;
  }
}
