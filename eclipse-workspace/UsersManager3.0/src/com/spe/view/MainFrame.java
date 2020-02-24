package com.spe.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainFrame
 */
@WebServlet("/MainFrame")
public class MainFrame extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrame() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		//1.init page
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//		//get uname
//		String username=request.getParameter("uname");
//		String password=request.getParameter("pass");
//		String username02=(String) request.getSession().getAttribute("loginUser");
//		//get session
//		User user=(User) request.getSession().getAttribute("userobj");
		//2.response
		
		out.println("<span>hello xx</span>");
		
		
		out.println("<a href='/UsersManager3.0/Login'>Sign out</a>");
		
		out.println("<hr/>");
		out.println("<h3>plz select</h3>");
		out.println("<a href='/UsersManager3.0/ManageUsers'>Manage users</a><br/>");
		out.println("<a href='/UsersManager3.0/Login'>Add users</a><br/>");
		out.println("<a href='/UsersManager3.0/Login'>Find users</a><br/>");
		out.println("<a href='/UsersManager3.0/Login'>Exit</a><br/>");
		out.println("<hr/>");
		//sql
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
