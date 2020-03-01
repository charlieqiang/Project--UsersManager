package com.spe.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RefreshController
 */
@WebServlet("/RefreshController")
public class RefreshController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefreshController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();  
        
        try {  
        	//abundon cache
            response.setHeader("Cache-Control", "no-store");  
            response.setHeader("Pragma", "no-cache");  
            response.setDateHeader("Expires", 0);  
            
            String cities[] =request.getParameterValues("city[]");
//          System.out.println(cities[1]);
            
            String temp="[";
            DecimalFormat df = new DecimalFormat("#.##");
            
            //random data
            for(int i=0;i<cities.length;i++) {
            	if(i==(cities.length-1)) {
            		
            		temp+="{\"cityname\":\""+cities[i]+"\",\"price\":\""+df.format(Math.random()*1500)+"\"}]";
            	} else {
            		temp+="{\"cityname\":\""+cities[i]+"\",\"price\":\""+df.format(Math.random()*1500)+"\"},";
            	}
            }
            
            //line 3
            out.print(temp);
        } finally {   
            out.close();  
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
