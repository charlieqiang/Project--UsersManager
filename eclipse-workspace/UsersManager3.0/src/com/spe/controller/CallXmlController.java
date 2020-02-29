package com.spe.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CallXmlController
 */
@WebServlet("/CallXmlController")
public class CallXmlController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallXmlController() {
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
            String id = request.getParameter("id");
            //data
            String OkInfo = "<res><msg>OK</msg></res>";
            String NoInfo = "<res><msg>NO</msg></res>";
            //line 3
            if(id.equals("char")) {  
                out.print(OkInfo);  
            }  
            else {  
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
