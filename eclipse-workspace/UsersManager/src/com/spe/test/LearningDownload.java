package com.spe.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LearningDownload
 */
@WebServlet("/LearningDownload")
public class LearningDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearningDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//PrintWriter out = response.getWriter();
		//
		response.setHeader("Content-Disposition", "attachment;filename=shoes.jpeg");
		//get the url
		String path=this.getServletContext().getRealPath("/images/shoes.jpeg");
//		System.out.println("path="+path);
		//set io
		FileInputStream fis=new FileInputStream(path);
		byte buff[]=new byte[1024];
		int len=0;//how many byte
		OutputStream os = response.getOutputStream();
		while((len=fis.read(buff))>0) {
			os.write(buff,0,len);
			
		}
		os.close();
		fis.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
