package com.spe.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.domain.User;

/**
 * Servlet implementation class UpdateUserView
 */
@WebServlet("/UpdateUserView")
public class UpdateUserView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//get userbean
		User user = (User) request.getAttribute("userinfo");
		//disp
		out.println("<form action='/UsersManager3.0/UserControllor?type=update' method='post'>");
		out.println("<table border=1 width=500px>");
		out.println("<tr><td>id</td><td><input type='text' name='id' readonly value='"+user.getId()+"'/></td></tr>"
				+ "<tr><td>username</td><td><input type='text' name='username' value='"+user.getName()+"'/></td></tr>"
				+ "<tr><td>email</td><td><input type='text' name='email' value='"+user.getEmail()+"'/></td></tr>"
				+ "<tr><td>grade</td><td><input type='text' name='grade' value='"+user.getGrade()+"'/></td></tr>"
				+ "<tr><td>password</td><td><input type='text' name='passwd' value='"+user.getPwd()+"'/></td></tr>"
				+ "<tr><td><input type='submit' value='change'/></td><td><input type='reset' value='reset'/></td></tr>");
		out.println("</form></table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
