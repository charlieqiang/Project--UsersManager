package com.spe.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.spe.domain.User;
import com.spe.service.UserService;

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
		
		
		//System.out.println("get");
		//1.request
		//resorve the bug code
		request.setCharacterEncoding("utf-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String checkcode=request.getParameter("checkcode");
		//new 
		UserService userService=new UserService();
		User user=new User();
		User userOk=new User();
		user.setId(Integer.parseInt(id));
		user.setPwd(password);
		//get session
		String checkcodeS=(String) request.getSession().getAttribute("checkcode");
		
		//check code
		if(checkcode.equals(checkcodeS)) {
			if(userService.checkUser(user)) {
				//
				userOk=UserService.getUserById(id);
				HttpSession session=request.getSession();
				session.setAttribute("login", user);
				String nums=(String) this.getServletContext().getAttribute("nums");
				
				this.getServletContext().setAttribute("nums", ""+(Integer.parseInt(nums)+1));
				this.getServletContext().setAttribute("username", userOk.getName());
				
				
				response.sendRedirect("/UsersManager3.0/MainFrame");
				
			}else {
				request.setAttribute("err", "UserId or password wrong.");
				request.getRequestDispatcher("/Login").forward(request, response);
				
			}
		}else {
			request.setAttribute("err", "checkcode wrong.");
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
