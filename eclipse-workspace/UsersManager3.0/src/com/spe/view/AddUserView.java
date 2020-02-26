package com.spe.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.domain.User;

/**
 * Servlet implementation class AddUserView
 */
@WebServlet("/AddUserView")
public class AddUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String username = "";
		String email = "";
		String grade = "";
		String passwd = "";			
		
		//pull cookie
		Cookie cookies[]=request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("usernameC")) {
					username = cookie.getValue();
					System.out.println(username);
				}
			}
		}
		
		User user = (User) request.getAttribute("userinfo");
		//disp
		out.println("<form action='/UsersManager3.0/UserControllor?type=add' method='post'>");
		out.println("<table border=1 width=500px>");
		out.println( "<tr><td>username</td><td><input type='text' name='username' value='"+username+"'/></td></tr>"
				+ "<tr><td>email</td><td><input type='text' name='email'/></td></tr>"
				+ "<tr><td>grade</td><td><input type='text' name='grade'/></td></tr>"
				+ "<tr><td>password</td><td><input type='text' name='passwd''/></td></tr>"
				+ "<tr><td>keep?</td><td><input type='checkbox' name='keep' value='keep'/></td></tr>"
				+ "<tr><td><input type='submit' value='add'/></td><td><input type='reset' value='reset'/></td></tr>");
		out.println("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
