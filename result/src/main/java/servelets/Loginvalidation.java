package servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moelimplimetaton.interaceimplimentation;

/**
 * Servlet implementation class Loginvalidation
 */
@WebServlet("/Loginvalidation")
public class Loginvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginvalidation() {
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
		String Accountno=request.getParameter("username");
		String password=request.getParameter("password");
		Cookie cookie=new Cookie("Account_no", Accountno);
		Cookie ck=new Cookie("password",password);
		response.addCookie(ck);
		response.addCookie(cookie);
		interaceimplimentation m=new interaceimplimentation();
		boolean r=m.loginvalidation(Accountno, password);
		String username=m.username(Accountno);
		Cookie cok=new Cookie("username", username); 
		response.addCookie(cok);
		 
		if(r==true)
		{
			RequestDispatcher red=request.getRequestDispatcher("/home.html");
			red.include(request, response);
			//out.println("welcome  "+username);
		}
		else
		{
			out.println("<html><body>");

	        // Add JavaScript code to display a pop-up box
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Please enter valid user name password');");
	        out.println("</script>");

	        out.println("</body></html>");
			RequestDispatcher red=request.getRequestDispatcher("/Login.html");
			red.include(request, response);
			
			
			
		}
		
		/*
		 * request.setAttribute("accountno", username); RequestDispatcher reqd
		 * =request.getRequestDispatcher("pinvalidation");
		 * reqd.forward(request,response);
		 */
        
        // Forward the Request Dis
		
		
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
