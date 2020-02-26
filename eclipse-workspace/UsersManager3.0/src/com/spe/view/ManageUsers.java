package com.spe.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.domain.User;
import com.spe.service.UserService;

/**
 * Servlet implementation class ManageUsers
 */
@WebServlet("/ManageUsers")
public class ManageUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageUsers() {
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
		
		out.println("<script type='text/javascript' language='javascript'>");
		out.println(""
				+ "function gotoPage(){"
				+ "var pageNow=document.getElementById('pageNow').value;"
				+ "window.open('/UsersManager3.0/ManageUsers?pageNow='+pageNow,'_self');"
				+ "}"
				+ "function confirmDel(){"
				+ "return window.confirm('It will delete the user!');"
				+ "}"
				+ "</script>");
		out.println("<span>hello xx</span>");
		
		out.println("<a href='/UsersManager3.0/Login'>Sign out</a>");
		out.println("<hr/>");
		
		out.println("<h1>ManageUsers</h1>");
		
		
		
//		Connection ct=null;
//		PreparedStatement ps=null;
//		ResultSet rs=null;
//		String driver = "com.mysql.jdbc.Driver";
//		String sql = "jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC";
//		String user = "root";
//		String passwd = "123456";
		
		//set page
		int pageNow=1;
		int pageSize=3;
		int pageCount=1;
//		int rowCount=1;
		
		String pageNowString=request.getParameter("pageNow");
		if(pageNowString!=null) {
			pageNow=Integer.parseInt(pageNowString);
		}
		
		try {

			UserService userService=new UserService();
			
			pageCount = UserService.getPageCount(pageSize);
//			
//			ps = ct.prepareStatement("select * from users  limit "+((pageNow-1)*pageSize)+","+pageSize+";");
			//4.do it
//			rs=ps.executeQuery();
			
			ArrayList<User> al =userService.getUserByPage(pageNow, pageSize);
			
			//5.solve
			out.println("<table border=1 width=500px>");
			out.println("<tr><th>id</th>"
					+ "<th>username</th>"
					+ "<th>email</th>"
					+ "<th>grade</th>"
					+ "<th>change</th>"
					+ "<th>delete</th></tr>");
//			while(rs.next()) {
			for(User u:al) {
				out.println("<tr><td>"+u.getId()+
						"</td><td>"+u.getName()+
						"</td><td>"+u.getEmail()+
						"</td><td>"+u.getGrade()+
						"</td><td>"+"<a href='/UsersManager3.0/UserControllor?type=gotoUpdView&id="+u.getId()+"'>change</a>"+
						"</td><td>"+"<a onclick='return confirmDel();'href='/UsersManager3.0/UserControllor?type=del&id="+u.getId()+"'>delete</a>"+
						"</td></tr>");
			}
			out.println("</table><br/>");
			//disp page num
			if(pageNow!=1) {
				out.println("<a href='/UsersManager3.0/ManageUsers?pageNow="+(pageNow-1)+"'>previous</a>");
				
			}
			
			for(int i=1;i<=pageCount;i++) {
				out.println("<a href='/UsersManager3.0/ManageUsers?pageNow="+i+"'><"+i+"></a>");
			}
			
			if(pageNow!=pageCount) {
				out.println("<a href='/UsersManager3.0/ManageUsers?pageNow="+(pageNow+1)+"'>next</a>");
				
			}
			
			out.println("&nbsp;&nbsp;&nbsp;"+pageNow+"/"+pageCount);
			out.println("<br/>jump to <input id='pageNow' type='text' name='pageNow'/><input type='button' onClick='gotoPage()' value='jump'>");
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("err", "UserId or password wrong.");
			request.getRequestDispatcher("/Login").forward(request, response);
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
