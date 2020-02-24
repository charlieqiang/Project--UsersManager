package com.spe.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.init page
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//2.response
		out.println("<hr/>");
		out.println("<h1>hello world</h1>");
		out.println("<form action='/UsersManager3.0/LoginController' method='GET'>");
		out.println("UserId:<input type='text' name='id'/><br/>");
		out.println("Password:<input type='password' name='password'/><br/>");
		out.println("<input type='submit' value='Sign in' value='signIn'<br/>");
		out.println("</form>");
		
		String errInfo=(String) request.getAttribute("err");
		if(errInfo!=null) {
			out.println("errInfo:"+errInfo);
		}
		
		out.println("<hr/>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
