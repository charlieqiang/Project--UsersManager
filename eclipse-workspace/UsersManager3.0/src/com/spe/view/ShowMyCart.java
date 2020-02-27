package com.spe.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.domain.Book;

/**
 * Servlet implementation class ShowMyCart
 */
@WebServlet("/ShowMyCart")
public class ShowMyCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowMyCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		HashMap<String,Book> myBooks=(HashMap<String,Book>)request.getSession().getAttribute("mybooks");
		out.println("<h1>Your Card</h1>");
		//
		Iterator iterator=myBooks.keySet().iterator();
		while(iterator.hasNext()) {
			String key=(String)iterator.next();
			Book book=myBooks.get(key);
			out.print(book.getName()+"×"+book.getNum()+"<br/>");
		}
		String url=response.encodeURL("/UsersManager3.0/ShowBook");
		out.print("<a href='"+url+"'>go back</a>");

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
