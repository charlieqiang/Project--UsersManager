package com.spe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		String u=request.getParameter("username");
		String p=request.getParameter("password");
		String s=request.getParameter("sex");
		String c=request.getParameter("city");
		String hd=request.getParameter("hidden");
		String it=request.getParameter("intro");
		String[] h=request.getParameterValues("hobby");
		
		out.println("username:"+u+"<br/>");
		out.println("password:"+p+"<br/>");
		out.println("sex:"+s+"<br/>");
		if(h!=null) {
			for(int i=0;i<h.length;i++) {
				out.println("hobby"+i+":"+h[i]+"<br/>");
			} 
		}else {
			out.println("no hobby"+"<br/>");
		}
		out.println("city:"+c+"<br/>");
		out.println("intro:"+it+"<br/>");
		out.println("hidden:"+hd+"<br/>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
