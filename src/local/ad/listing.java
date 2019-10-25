package local.ad;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.Document;

import local.ad.adClass;
import local.ad.function;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * Servlet implementation class listing
 */
@WebServlet("/listing")
public class listing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String category=(String) session.getAttribute("category");
		MongoClient service=MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database=service.getDatabase("gopal");
		MongoCollection<Document> Collection=database.getCollection("Allnew");
		List<adClass> categoryAds=new LinkedList<>();
		MongoCursor<Document> cursor1=Collection.find(Filters.eq("Category",category)).iterator();
		while (cursor1.hasNext()) {
			Document d = (Document) cursor1.next();	
			adClass ad = new adClass(d.getString("Name"),category,d.getString("Desc"),d.getLong("Number"),d.getString("email"),d.getString("City"),d.getInteger("zip"));
			categoryAds.add(ad);
		}
		request.setAttribute("list", categoryAds);
		//request.setAttribute("category", category);
		//request.getRequestDispatcher("listing.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session=request.getSession();
		String category=(String) session.getAttribute("category");
		MongoClient service=MongoClients.create("mongodb://localhost:27017");
		MongoDatabase database=service.getDatabase("gopal");
		MongoCollection<Document> Collection=database.getCollection("Allnew");
		List<adClass> categoryAds=new LinkedList<>();
		if(request.getParameter("adTitle")!=null&&request.getParameter("adDesc")!=null&&request.getParameter("email")!=null&&request.getParameter("contactNumber")!=null&&request.getParameter("city")!=null&&(request.getParameter("zip")!=null)) 
		{
		String name=request.getParameter("adTitle");
		String desc=request.getParameter("adDesc");
		long number=Long.parseLong(request.getParameter("contactNumber"));
		String email=request.getParameter("email");
		String city=request.getParameter("city");
		int zip=Integer.parseInt(request.getParameter("zip"));
		
		
		Document document=new Document("Name",name).append("Category", category).append("Desc", desc).append("Number", number).append("email", email).append("City",city).append("zip", zip);
		Collection.insertOne(document);
		MongoCursor<Document> cursor1=Collection.find(Filters.eq("Category",category)).iterator();
		while (cursor1.hasNext()) {
			Document d = (Document) cursor1.next();	
			adClass ad = new adClass(d.getString("Name"),category,d.getString("Desc"),d.getLong("Number"),d.getString("email"),d.getString("City"),d.getInteger("zip"));
			categoryAds.add(ad);
			
		}
		request.setAttribute("list", categoryAds);
		
	}
		
		request.getRequestDispatcher("listing.jsp").forward(request, response);
		
	}
}
