package com.spe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CallCountryController
 */
@WebServlet("/CallCountryController")
public class CallCountryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallCountryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();  
        try {  
            response.setHeader("Cache-Control", "no-store");  
            //abundon cache
            response.setHeader("Pragma", "no-cache");  
            response.setDateHeader("Expires", 0);  
            String province = request.getParameter("province");
            //data
            String OkInfo = "<province><city>Quanzhou</city><city>Xiamen</city></province>";
            String NoInfo = "<province><city>Niaochao</city><city>Shuilifang</city></province>";
            //line 3
            if(province.equals("Fujian")) {  
                out.print(OkInfo);  
            }  
            else if(province.equals("Beijing")){  
                out.print(NoInfo);  
            }  
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
