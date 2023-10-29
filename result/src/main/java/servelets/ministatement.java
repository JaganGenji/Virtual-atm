package servelets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.transaction_model;
import moelimplimetaton.interaceimplimentation;

/**
 * Servlet implementation class ministatement
 */
@WebServlet("/ministatement")
public class ministatement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ministatement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie ck[]=request.getCookies();
		String Accountno=null;
		PrintWriter out=response.getWriter();
		for(Cookie c:ck)
		{
			if(c.getName().equals("Account_no"))
			{
				Accountno=c.getValue();
			}
		}
		interaceimplimentation i=new interaceimplimentation();
		List<transaction_model> res=i.ministatement(Accountno);
		  out.print("<table border='1' width='100%'");  
	        out.print("<tr><th>Account_No</th><th>Name</th><th>Money</th><th>Status</th><th>Balance</th><th>Date && Time</th>></tr>");
	        for(transaction_model r:res)
	        {
	        	out.print("<tr><th>"+r.getAccount_no()+"</th><th>"+r.getName()+"</th><th>"+r.getAmmount()+"</th><th>"+r.getStatus()+"</th><th>"+r.getBalance()+"</th><th>"+r.getDate_Time()+"</th>></tr>");
	        }
	   out.print("</table>");
	  // out.println("<button type=\"button\" onclick=\"window.location.href='Thanks.html'\"> Back</button>");
	   out.println("<script>");
	    out.println("setTimeout(function() {");
	    out.println("  window.location.href = 'Thanks.html';"); // Replace with your desired URL
	    out.println("}, 5000);");
	    out.println("</script>");
		
		// TODO Auto-generated method stub
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
