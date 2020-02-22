package com.spe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.domain.User;
import com.spe.utils.Mytools;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		//1.request
		//resorve the bug code
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		
		Connection ct=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String driver = "com.mysql.jdbc.Driver";
		String sql = "jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC";
		String user = "root";
		String passwd = "123456";
		try {
			//1.load driver
			Class.forName(driver);
			//2.get connetion
			ct=DriverManager.getConnection(sql,user,passwd);
			//3.create preparedStatement
			ps = ct.prepareStatement("select * from users where id=? and passwd=?");
			//inject
			ps.setObject(1, id);
			ps.setObject(2, password );
			
			//4.do it
			rs=ps.executeQuery();
			//5.solve
			if(rs.next()) {
				request.getRequestDispatcher("/MainFrame").forward(request, response);
			}else {
				request.getRequestDispatcher("/Login").forward(request, response);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ct!=null)
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	
//		String test=Mytools.getNewString(username);
//		
//		//2.check
//		if("123".equals(password)) {
//			//learning session
//			request.getSession().setAttribute("loginUser", username);
//			
//			//session get obj
//			User user1=new User();
//			user1.setName(username);
//			user1.setPwd(password);
//			request.getSession().setAttribute("userobj", user1);
//			
//			//jump:1sendredircte2forward
//			response.sendRedirect("/UsersManager/MainFrame?uname="+test+"&pass="+password);
//		}else {
//			//jump back
//			response.sendRedirect("/UsersManager/Login");
//		}
//	}
//}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
