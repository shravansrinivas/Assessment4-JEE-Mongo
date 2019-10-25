package local.ad;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class function
 */
@WebServlet("/function")
public class function extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public function() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
		String choice="";
		
		if(request.getParameter("option")!=null)
		{
			choice=request.getParameter("option");
			switch(choice) {
			case "Community":
				session.setAttribute("category", "Community");
				//request.setAttribute("category", "Community");
				
				break;
			case "Events":
				session.setAttribute("category", "Events");
				
				break;
			case "Sales":
				session.setAttribute("category", "Sales");
				
				break;
			case "Jobs":
				session.setAttribute("category", "Jobs");
				
				break;
			case "Services":
				session.setAttribute("category", "Services");
				
				break;	
				
			}
		
			request.getRequestDispatcher("listing").forward(request, response);
			
		}
	}

}
