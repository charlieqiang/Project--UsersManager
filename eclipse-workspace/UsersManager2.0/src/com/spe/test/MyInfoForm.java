package com.spe.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyInfoForm
 */
@WebServlet("/MyInfoForm")
public class MyInfoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyInfoForm() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("<h1>Sign in</h1>");
		out.println("<form action='/UsersManager/RegisterController' method='post'>");
		out.println("Username:<input type='text' name='username'/><br/>");
		out.println("Password:<input type='password' name='password'/><br/>");
		out.println("Hobby:<input type='checkbox' name='hobby' value='Music'/>Music"
				+ "<input type='checkbox' name='hobby' value='Sport'/>Sport"
				+ "<input type='checkbox' name='hobby' value='Travel'/>Travel<br/>");
		out.println("City:<select name='city'/><option value='beijing'>Beijing<option value='Fujian'>Fujina<select/><br/>");
		out.println("Sex:<input type='radio' name='sex' value='Man'/>Man<input type='radio' name='sex' value='Woman'/>Woman<br/>");
		out.println("About you:<textarea cols='20' rows='10' name='intro'>plz input...</textarea><br/>");
		out.println("Photo:<input type='file' name='photo'><br/>");
		//the data will not be on the view
		out.println("<input type='hidden' value='test' name='hidden'/>");
		out.println("<input type='submit' value='Sign up'<br/>");
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
