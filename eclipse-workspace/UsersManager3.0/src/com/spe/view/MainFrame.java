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
		//get login user
		User u=(User) request.getSession().getAttribute("login");
		//check
		if(u==null) {
			request.setAttribute("err", "plz input userid and passwd");
			request.getRequestDispatcher("/Login").forward(request, response);
			return;
		}
		//1.init page
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
//		//get uname
//		String username=request.getParameter("username");
//		String password=request.getParameter("pass");
//		String username02=(String) request.getSession().getAttribute("loginUser");
//		//get session
//		User user=(User) request.getSession().getAttribute("userobj");
		//2.response
		String nums=this.getServletContext().getAttribute("nums").toString();
		String username=this.getServletContext().getAttribute("username").toString();
		request.getSession().setAttribute("username",username);
		out.println("<span>Hi,"+username+"!  There are "+nums+" users online!</span>");
		
		
		out.println("<a href='/UsersManager3.0/Login'>Sign out</a>");
		
		out.println("<hr/>");
		out.println("<h3>plz select</h3>");
		out.println("<a href='/UsersManager3.0/GoToManageController'>Manage users</a><br/>");
		out.println("<a href='/UsersManager3.0/UserControllor?type=gotoAddUser'>Add users</a><br/>");
		out.println("<a href='/UsersManager3.0/ShowBook'>Show Book</a><br/>");
		out.println("<a href='friendList.jsp?seter="+username+"'>Chat Room</a><br/>");
		out.println("<a href='/UsersManager3.0/ShowMyCart'>Show My Cart</a><br/>");
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
