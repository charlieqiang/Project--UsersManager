package com.spe.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo01
 */
@WebServlet("/Demo01")
public class Demo01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Demo01() {
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

		boolean b=false;
//		pushCookie.setMaxAge(3600);
//		response.addCookie(pushCookie);
		Cookie pushCookie = new Cookie("lasttime", "");
		Cookie pullCookie[]=request.getCookies();
		SimpleDateFormat timeformat=new SimpleDateFormat();
		String nowTime=null;
		if(pullCookie!=null) {
			for(Cookie cookie:pullCookie) {
				String name=cookie.getName();
				
				if("lasttime".equals(name)) {
					out.println("last time:"+cookie.getValue());
					//update
					//set cookie
					timeformat=new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
					nowTime=timeformat.format(new java.util.Date());
					cookie.setValue(nowTime);
					pushCookie.setMaxAge(7*3600*24);
					response.addCookie(cookie);
					b=true;
					break;
				}
//				for(int i=0;i<pullCookie.length;i++) {
//					Cookie cookie=pullCookie[i];
//					out.println("msg:"+cookie.getName()+"--"+cookie.getValue()+"<br/>");
//				}
			}
		}
		
		if(!b) {
			out.println("welcome!");
			//set cookie
			timeformat=new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
			nowTime=timeformat.format(new java.util.Date());
//			System.out.println(nowTime);
			pushCookie = new Cookie("lasttime",nowTime);
			pushCookie.setMaxAge(7*3600*24);
			response.addCookie(pushCookie);
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
