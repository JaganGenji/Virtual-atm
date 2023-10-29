package servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.modelelements;
import moelimplimetaton.interaceimplimentation;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		// PrintWriter out=response.getWriter(); 
		 String name =
		  request.getParameter("name");
		 
		  String Accountno = request.getParameter("Accountno"); String mobile =
		  request.getParameter("mobile"); String email = request.getParameter("email");
		  String gender = request.getParameter("gender"); String password =
		  request.getParameter("password"); String dateOfBirth =
		  request.getParameter("dateOfBirth"); String address =
		  request.getParameter("address");
		  
			/*
			 * modelelements m=new modelelements(name, Accountno, mobile, email, gender,
			 * password, dateOfBirth, address); interaceimplimentation i=new
			 * interaceimplimentation(); int r=i.registration(m);
			 */
		/*
		 * String name = "jagan"; String Accountno = "12334"; String mobile =
		 * "123456789"; String email = "jagan@gmail.com"; String gender ="male"; String
		 * password = "123@abc"; String dateOfBirth = "11-08-2003"; String address
		 * ="andhra";
		 */
		modelelements m=new modelelements(name, Accountno, mobile, email, gender, password, dateOfBirth, address);
		interaceimplimentation i=new interaceimplimentation();
		int r=i.registration(m);

		if(r==1) {
		//PrintWriter out=response.getWriter();
		if(r==1)
		{
			//out.println("Registered sucessfully!!");
			out.println("<html><body>");

	        // Add JavaScript code to display a pop-up box
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Registration sucessfully done');");
	        out.println("</script>");

	        out.println("</body></html>");
			
			RequestDispatcher red=request.getRequestDispatcher("/Login.html");
			red.include(request, response);
		
		}
		else
		{
			out.println("please enter valid one!!");
		}
		

	}

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
