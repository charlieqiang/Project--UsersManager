package com.spe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.domain.User;
import com.spe.service.UserService;

/**
 * Servlet implementation class DelControllor
 */
@WebServlet("/UserControllor")
public class UserControllor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserControllor() {
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//call service
		String type=request.getParameter("type");
		if("del".equals(type)) {
			//get id
			String id = request.getParameter("id");
			if(new UserService().delUser(id)) {
				//ok  forward
				request.setAttribute("info", "deleted");
				request.getRequestDispatcher("/updOK").forward(request, response);
				
			}else {
				request.setAttribute("info", "deleted err");
				request.getRequestDispatcher("/updErr").forward(request, response);
				
			}
		}else if ("gotoUpdView".equals(type)){
			//get id
			String id = request.getParameter("id");
			//through id get userbean
			User user = UserService.getUserById(id);
			//set user obj into request
			request.setAttribute("userinfo", user);
			//forward
			request.getRequestDispatcher("/UpdateUserView").forward(request, response);
			
		}else if ("gotoAddUser".equals(type)){
			//
			request.getRequestDispatcher("/AddUserView").forward(request, response);
			
		
		}else if ("add".equals(type)){
			//
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String grade = request.getParameter("grade");
			String passwd = request.getParameter("passwd");			
			String val=request.getParameter("keep");
			if(val!=null&&val.equals("keep")) {
				
				//cookie
				Cookie usernameC=new Cookie("usernameC", username);
				Cookie emailC=new Cookie("emailC", email);
				Cookie gradeC=new Cookie("gradeC", grade);
				Cookie passwdC=new Cookie("passwdC", passwd);
				usernameC.setMaxAge(7*24*3600);
				emailC.setMaxAge(7*24*3600);
				gradeC.setMaxAge(7*24*3600);
				passwdC.setMaxAge(7*24*3600);
				
				response.addCookie(usernameC);
				response.addCookie(emailC);
				response.addCookie(gradeC);
				response.addCookie(passwdC);
			}
			
			//package
			User user=new User();
			user.setEmail(email);
			user.setGrade(Integer.parseInt(grade));
			user.setName(username);
			user.setPwd(passwd);
			
			if(UserService.addUser(user)) {
				request.setAttribute("info", "added");
				request.getRequestDispatcher("/updOK").forward(request, response);

			}else {
				request.setAttribute("info", "adderr");
				request.getRequestDispatcher("/updErr").forward(request, response);
				
			}
			
			if(val!=null&&val.equals("keep")) {
				
			}
		}else if ("update".equals(type)){
			//get id
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			String email = request.getParameter("email");
			String grade = request.getParameter("grade");
			String passwd = request.getParameter("passwd");
			
			//package
			User user=new User(Integer.parseInt(id),username,email,Integer.parseInt(grade),passwd);
		
			if(UserService.updUser(user)) {
				request.setAttribute("info", "chaged");
				request.getRequestDispatcher("/updOK").forward(request, response);
				
			}else {
				request.setAttribute("info", "chagederr");
				request.getRequestDispatcher("/updErr").forward(request, response);
				
			}
			
			
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
