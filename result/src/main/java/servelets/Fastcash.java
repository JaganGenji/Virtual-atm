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
 * Servlet implementation class Fastcash
 */
@WebServlet("/Fastcash")
public class Fastcash extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fastcash() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubresponse.setContentType("HTML/text");
		Integer amount=Integer.parseInt(request.getParameter("amount"));
		PrintWriter out=response.getWriter();
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
		if(amount==0)
		{
			RequestDispatcher res=request.getRequestDispatcher("/Debit.html");
			res.forward(request, response);
		}
		
		int r=i.Debite(username, Account_no, amount);
		if(r==1)
		{
			out.println("<html><body>");

	        
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Amount Sucessfully debited!');");
	        
	        //out.println("var confirmation = confirm('Are you sure you want to continue?');");
	        
	        out.println("</script>");

	        out.println("</body></html>");
	        RequestDispatcher rd=request.getRequestDispatcher("Thanks.html");
	        rd.include(request, response);
	        
		}
		else
		{
               out.println("<html><body>");

	        
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Failed to debit!');");
	        
		}
		//out.println("<h1> amount===="+amount+"</h1>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
