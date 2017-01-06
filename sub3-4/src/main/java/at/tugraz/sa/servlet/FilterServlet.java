package at.tugraz.sa.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "FilterServlet", urlPatterns = { "/filter" })
public class FilterServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterServlet()
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
		String name = request.getParameter("name");
		String longitude = request.getParameter("longitude");
		String latitude = request.getParameter("latitude");
		String lonMode = request.getParameter("lonMode");
    String latMode = request.getParameter("latMode");

    try
    {
      lonMode = lonMode.equals("lonLower") ? "<" : ">";
      latMode = latMode.equals("latLower") ? "<" : ">";

      Filter filter = new Filter(name, longitude, latitude, lonMode, latMode);
      List<StopsRecord> records = filter.start();

      String list = new String();
      for (StopsRecord sr : records)
      {
        list = addElement(list, sr.getName());
      }

      request.setAttribute("results", records.size());
      request.setAttribute("list", list);
      request.getRequestDispatcher("filter.jsp").include(request, response);
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
    list += "<option>";
    list += element;
    list += "</option>";
    list += "\n";

    return list;
  }
}
