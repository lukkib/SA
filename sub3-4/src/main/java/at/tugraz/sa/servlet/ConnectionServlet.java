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
 * Servlet implementation class Connection
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

    try
    {
      List<String> results= new ArrayList<String>();
      StopController stopController = new StopController();
      DataHandler handler = new DataHandler();

      String list = new String();

      if (start.isEmpty() || destination.isEmpty())
      {
        request.getRequestDispatcher("connectionHome.jsp").include(request, response);
        return;
      }
      else
      {
        Planer planer = new Planer(stopController.findStopIdByName(start),
          stopController.findStopIdByName(destination));
        results = planer.findConnections(handler);

        int size = 0;
        for (int i = 0; i < results.size(); i++)
        {
          String element = handler.getRoutebyID(results.get(i));
          if (element != null)
          {
            list = addElement(list, element);
            size++;
          }
        }
        request.setAttribute("results", size);
        request.setAttribute("list", list);
        request.getRequestDispatcher("connection.jsp").include(request, response);
        return;
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }

    request.getRequestDispatcher("connectionHome.jsp").include(request, response);
    return;
  }

  private String addElement(String list, String element)
  {
    list += "<option>";
    list += element;
    list += "</option>";
    list += "\n";

    return list;
  }
}
