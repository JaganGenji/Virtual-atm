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
 * Servlet implementation class Deposite
 */
@WebServlet("/Deposite")
public class Deposite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deposite() {
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
		Integer amount=Integer.parseInt(request.getParameter("amount"));
		interaceimplimentation i=new interaceimplimentation();
		Cookie ck[]=request.getCookies();
		String username=null;
		String Account_no=null;
		for(Cookie c:ck)
		{
			if(c.getName().equals("username"))
			{
				username=c.getValue();
			}
			if(c.getName().equals("Account_no"))
			{
				Account_no=c.getValue();
			}
		}
		int res=i.Deposite(Account_no, amount, username);
		if(res==1)
		{
			//out.print("Sucessfully deposited");
			out.println("<html><body>");

	        // Add JavaScript code to display a pop-up box
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Amount Sucessfully deposited');");
	        out.println("</script>");

	        out.println("</body></html>");
			 RequestDispatcher rd=request.getRequestDispatcher("Thanks.html");
		        rd.include(request, response);
		}
		else
		{
		//	out.print("failed to deposite");
			out.println("<html><body>");

	        // Add JavaScript code to display a pop-up box
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Amount failed to deposite');");
	        out.println("</script>");

	        out.println("</body></html>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
