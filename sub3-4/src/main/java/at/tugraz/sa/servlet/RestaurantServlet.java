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
import at.tugraz.sa.controller.Restaurant;

/**
 * Servlet implementation class Restaurant
 */
@WebServlet(name = "RestaurantServlet", urlPatterns = { "/restaurant" })
public class RestaurantServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public RestaurantServlet()
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
    String stop = request.getParameter("stop");
    String distance = request.getParameter("distance");

    try
    {
      StopController sr = new StopController();
      if (!sr.stopExists(stop))
      {
        request.getRequestDispatcher("restaurantHome.jsp").include(request, response);
        return;
      }

      DataHandler handler = new DataHandler();
      List<Restaurant> restaurantList = handler.findRestaurantsNearStop(stop, distance);

      String list = new String();
      for (Restaurant r : restaurantList)
      {
        list = addElement(list, r.getName());
      }
      request.setAttribute("results", restaurantList.size());
      request.setAttribute("list", list);
      request.getRequestDispatcher("restaurant.jsp").include(request, response);
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
//    catch (Exception e) // TODO Add custom exception
//    {
//      System.err.println("TODO: Throw custom exception or handle invalid " +
//        "mode!");
//    }
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
