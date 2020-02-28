package com.spe.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.domain.User;

/**
 * Servlet implementation class DemoMask
 */
@WebServlet("/DemoMask")
public class DemoMask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoMask() {
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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		String name = "";
		String idcard = "";
		String mobile = "";
		String point_id = "";			
		String date = "";			
		String time = "";			
		
		//pull cookie
		Cookie cookies[]=request.getCookies();
		if(cookies!=null) {
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("nameC")) {
					name = cookie.getValue();
				}
				if(cookie.getName().equals("idcardC")) {
					idcard = cookie.getValue();
				}
				if(cookie.getName().equals("mobileC")) {
					mobile = cookie.getValue();
				}
				if(cookie.getName().equals("point_idC")) {
					point_id = cookie.getValue();
				}
				if(cookie.getName().equals("dateC")) {
					date = cookie.getValue();
				}
				if(cookie.getName().equals("timeC")) {
					time = cookie.getValue();
				}
			}
		}
		
		User user = (User) request.getAttribute("userinfo");
		//disp
		out.println("<form action='/UsersManager3.0/MaskController' method='post'>");
		out.println("<table border=1 width=500px>");
		out.println( "<tr><td>姓名</td><td><input  style='width:200px;' type='text' name='name' value='"+name+"'/></td></tr>"
				+ "<tr><td>身份证</td><td><input style='width:200px;'  type='text' name='idcard'value='"+idcard+"'/></td></tr>"
				+ "<tr><td>手机号</td><td><input style='width:200px;'  type='text' name='mobile'value='"+mobile+"'/></td></tr>"
				+ "<tr><td>地址号</td><td><input style='width:200px;'  type='text' name='point_id'value='"+point_id+"'/></td></tr>"
				+ "<tr><td>日期</td><td><input style='width:200px;'  type='text' name='date'value='"+date+"'/></td></tr>"
				+ "<tr><td>时间</td><td><input style='width:200px;'  type='text' name='time'value='"+time+"'/></td></tr>"
				+ "<tr><td><input type='submit' value='开抢'/></td><td><input type='reset' value='重置'/></td></tr>");
		out.println("</form>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
