package com.spe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spe.domain.Book;

/**
 * Servlet implementation class buyBook
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String bookname = request.getParameter("name");
		String id=request.getParameter("id");
		HttpSession session=request.getSession();
		HashMap<String,Book> hm = (HashMap<String,Book>) session.getAttribute("mybooks");
		//check have book
		if(hm==null) {
			hm = new LinkedHashMap<String,Book>();
			Book book=new Book();
			book.setId(id);
			book.setName(bookname);
			book.setNum(1);
			hm.put(id,book);
			session.setAttribute("mybooks", hm);
		}else {
			//check
			if(hm.containsKey(id)) {
				//boun
				Book book=hm.get(id);
				int bookNum=book.getNum();
				book.setNum(bookNum+1);
				
			}else {
				Book book = new Book();
				book.setId(id);
				book.setName(bookname);
				book.setNum(1);
				
				hm.put(id,book);
			}
			//no im
			session.setAttribute("mybooks", hm);
		}
		
		
		
		
		//jump
		request.getRequestDispatcher("/ShowMyCart").forward(request, response);
		
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
