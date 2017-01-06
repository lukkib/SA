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
@WebServlet("/FilterServlet")
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

		// TODO
    String lonMode = "<"; //searchLessLon.getId().equals("<") ? "<" : searchGreaterLon.getId();
    String latMode = "<"; //searchLessLat.getId().equals("<") ? "<" : searchGreaterLat.getId();

    try
    {
      Filter filter = new Filter(name, longitude, latitude, lonMode, latMode);
      List<StopsRecord> records = filter.start();
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
		
		System.out.println("SUCCESS");
		return;
	}

}