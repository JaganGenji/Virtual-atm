package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moelimplimetaton.interaceimplimentation;

/**
 * Servlet implementation class pinchanger
 */
@WebServlet("/pinchanger")
public class pinchanger extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pinchanger() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String Accountno = null;
		String newpassword=request.getParameter("New_password");
		Cookie ck[]=request.getCookies();
		for(Cookie c:ck)
		{
			if(c.getName().equals("Account_no"))
			{
				Accountno=c.getValue();
			}
		}
		String Conformpassword=request.getParameter("Conform_password");
		if(newpassword.equals(Conformpassword))
			
		{
			interaceimplimentation i=new interaceimplimentation();
			try {
				int res=i.PassswordChange(Accountno, newpassword);
				out.println("res="+res);
				out.println("<html><body>");

		        // Add JavaScript code to display a pop-up box
		        out.println("<script type=\"text/javascript\">");
		        out.println("alert('Password Sucessfully updated');");
		        out.println("</script>");

		        out.println("</body></html>");
		        RequestDispatcher rd=request.getRequestDispatcher("Thanks.html");
		        rd.include(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		else
		{
			out.println("<html><body>");

	        // Add JavaScript code to display a pop-up box
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Please enter New password and Conform password same!');");
	        out.println("</script>");

	        out.println("</body></html>");
			//out.println("please enter new password and conform password is same");
			RequestDispatcher rsd=request.getRequestDispatcher("/passwordchange.html");
			rsd.include(request, response);
		}
		// TODO Auto-generated method stub
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
