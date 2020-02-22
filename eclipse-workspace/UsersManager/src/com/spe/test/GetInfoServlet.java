package com.spe.test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spe.utils.Mytools;

/**
 * Servlet implementation class GetInfoServlet
 */
@WebServlet("/GetInfoServlet")
public class GetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetInfoServlet() {
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
		String url=request.getRequestURL().toString();
		String uri=request.getRequestURI().toString();
		//queryString
		String queryStrings[]=request.getQueryString().split("&");
		
		String addr=request.getRemoteAddr();
		String host=request.getRemoteHost();
		int port=request.getRemotePort();
		int hport=request.getLocalPort();
		
		for(String s: queryStrings) {
			System.out.println(Mytools.getNewString(s));
		}
		
		System.out.println("uri="+uri+"\r\n"
			+"url="+url+"\r\n"
//			+"queryString="+queryString+"\r\n"
			+"addr="+addr+"\r\n"
			+"host="+host+"\r\n"
			+"port="+port+"\r\n"
			+"host port="+hport+"\r\n"
			);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
