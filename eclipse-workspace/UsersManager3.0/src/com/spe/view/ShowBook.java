package com.spe.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.domain.Book;
import com.spe.domain.User;
import com.spe.service.BookService;
import com.spe.service.UserService;

/**
 * Servlet implementation class ShowBook
 */
@WebServlet("/ShowBook")
public class ShowBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBook() {
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
		
		out.println("<h1>welcome book store</h1>");
//		out.print("think in java<a href='/UsersManager3.0/buyBook?id=1&name=java'>cilck</a><br/>");
//		out.print("think in oracle<a href='/UsersManager3.0/buyBook?id=2&name=oracle'>cilck</a><br/>");
//		out.print("think in c++<a href='/UsersManager3.0/buyBook?id=3&name=c++'>cilck</a><br/>");
		try {

			BookService bookService=new BookService();
			
//			ps = ct.prepareStatement("select * from users  limit "+((pageNow-1)*pageSize)+","+pageSize+";");
			//4.do it
//			rs=ps.executeQuery();
			
			ArrayList<Book> al =bookService.getBook();
			
			
			out.println("<table border=1 width=200px>");
			out.println("<tr><th>id</th>"
					+ "<th>bookname</th>"
					+ "<th>buy</th>"
					+"</tr>");
//			while(rs.next()) {
			request.getSession();
			for(Book b:al) {
				
				String url=response.encodeURL("/UsersManager3.0/BookController?id="+b.getId()+"&name="+b.getName());
				
				out.println("<tr>"
						+ "<td>"+b.getId()+"</td>"+
						"<td align='center'>"+b.getName()+"</td>"+
						"<td><a href='"+url+"'>cilck</a><br/></td>"+
						"</tr>");
			} 
			out.println("</table><br/>");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
