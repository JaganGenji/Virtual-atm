package servelets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import moelimplimetaton.interaceimplimentation;

/**
 * Servlet implementation class pinvalidation
 */
@WebServlet("/pinvalidation")
public class pinvalidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	public pinvalidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = null;
		String Accountno = null;
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		Cookie ck[] = request.getCookies();
		for (Cookie c : ck) {
			if (c.getName().equals("username")) {
				username = c.getValue();
			}
			if (c.getName().equals("Account_no")) {
				Accountno = c.getValue();
			}
		}
		// String username=request.getParameter("username");
		String password1 = request.getParameter("password");
		interaceimplimentation m = new interaceimplimentation();
		boolean r = m.loginvalidation(Accountno, password1);
		if (r == true) {
			int res = m.balance(Accountno);
			out.println("<html><body>");
			out.println("<h1 style=\"background-color:DodgerBlue;\"> welcome to the page </h1>");
			out.println("<h1> amoount==" + res);
			out.println("</body></html>");
			out.println("<script>");
			out.println("setTimeout(function() {");
			out.println("  window.location.href = 'Thanks.html';"); // Replace with your desired URL
			out.println("}, 5000);");
			out.println("</script>");
			// out.println(" request=="+username);
			// out.print(password1);
		} else {
			out.println("you are not authorized" + username + "/t/t/t password" + password1);
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
