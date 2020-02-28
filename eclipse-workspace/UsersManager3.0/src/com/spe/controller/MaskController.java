package com.spe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.service.UserService;

/**
 * Servlet implementation class MaskController
 */
@WebServlet("/MaskController")
public class MaskController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaskController() {
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
		
		
		//
		String name = request.getParameter("name");
		String idcard = request.getParameter("idcard");
		String mobile = request.getParameter("mobile");
		String point_id = request.getParameter("point_id");
		String date = request.getParameter("date");			
		String time = request.getParameter("time");
		
		
			
		//cookie
		Cookie nameC=new Cookie("nameC", name);
		Cookie idcardC=new Cookie("idcardC", idcard);
		Cookie mobileC=new Cookie("mobileC", mobile);
		Cookie point_idC=new Cookie("point_idC", point_id);
		Cookie dateC=new Cookie("dateC", date);
		Cookie timeC=new Cookie("timeC", time);
		
		nameC.setMaxAge(7*24*3600);
		idcardC.setMaxAge(7*24*3600);
		mobileC.setMaxAge(7*24*3600);
		point_idC.setMaxAge(7*24*3600);
		dateC.setMaxAge(7*24*3600);
		timeC.setMaxAge(7*24*3600);
		
		response.addCookie(nameC);
		response.addCookie(idcardC);
		response.addCookie(mobileC);
		response.addCookie(point_idC);
		response.addCookie(dateC);
		response.addCookie(timeC);
		
		response.sendRedirect("http://axkzyy.xmshensou.com/index/index/form.html?date=2020-02-29&time=15:00-16:00");
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
