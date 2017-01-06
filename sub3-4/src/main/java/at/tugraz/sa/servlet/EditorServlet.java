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
 * Servlet implementation class Editor
 */
@WebServlet(name = "EditorServlet", urlPatterns = { "/editor" })
public class EditorServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public EditorServlet()
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
    String route = request.getParameter("route");
    String stop = request.getParameter("stop");

    System.out.println("route: " + route);
    System.out.println("stop: " + stop);

    try
    {
      List<String> results= new ArrayList<String>();
      DataHandler handler = new DataHandler();

      String list = new String();

      if (route.isEmpty() || stop.isEmpty())
      {
  //      results.add("Enter Start and Target");
  //      ObservableList<String> items = FXCollections.observableArrayList();
  //      items.add(results.get(0));
  //      routes.setItems(items);
        request.getRequestDispatcher("editorHome.jsp").include(request, response);
        return;
      }
      else
      {
      	StopController stopController = new StopController();
        String stopId = stopController.findStopIdByName(stop);
        String feedback;
        if (stopId == null)
        {
            feedback = "Stop doesn't exist.";
            request.setAttribute("feedback", feedback);
        }
        else
        {
            feedback = stop + " added to route " + route + " with ID " + stopId;
            System.out.println(feedback);
            handler.addLine(route);
            handler.addStopToLine(route, stopController.findStopIdByName(stop));
            request.setAttribute("feedback", feedback);
        }
        request.getRequestDispatcher("editor.jsp").include(request, response);
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
