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
 * Servlet implementation class fundtransfor
 */
@WebServlet("/fundtransfor")
public class fundtransfor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fundtransfor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String Accountno=null;
		PrintWriter out=response.getWriter();
		String transformAcc=request.getParameter("TransformAccountno");
		Integer amount=Integer.parseInt(request.getParameter("money"));
		interaceimplimentation i=new interaceimplimentation();
		Cookie ck[]=request.getCookies();
	
		for(Cookie c:ck)
		{
			
			if(c.getName().equals("Account_no"))
			{
				Accountno=c.getValue();
			}
		}
		int res=i.Transfor(Accountno, transformAcc, amount);
		if(res==1)
		{
			out.println("<html><body>");

	        // Add JavaScript code to display a pop-up box
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Money sucessfully transformed!');");
	        out.println("</script>");

	        out.println("</body></html>");
	        RequestDispatcher rd=request.getRequestDispatcher("Thanks.html");
	        rd.include(request, response);
		}
		else
		{
			out.println("<html><body>");

	        // Add JavaScript code to display a pop-up box
	        out.println("<script type=\"text/javascript\">");
	        out.println("alert('Money failed to transform!');");
	        out.println("</script>");

	        out.println("</body></html>");
		}
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
