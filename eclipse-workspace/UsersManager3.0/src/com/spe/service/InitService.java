package com.spe.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitService
 */
@WebServlet("/InitService")
public class InitService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		//core code!!
		super.init(config);
		FileReader fr=null;
        BufferedReader br=null;
		//open 
        String filePath=(String) this.getServletContext().getRealPath("/record.txt");
//        System.out.println(filePath);
		try {
			
			fr=new FileReader(filePath);
			br=new BufferedReader(fr);
			//get record.txt
			
			String nums=br.readLine();
			this.getServletContext().setAttribute("nums", nums);
			
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
            try {
                if(br!=null){
                    br.close();
                }
                if(fr!=null){
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }	
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		//get record.txt
		super.destroy();
		String path=this.getServletContext().getRealPath("/record.txt");
		FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw = new FileWriter(path);
            bw = new BufferedWriter(fw);
            String nums = (String) this.getServletContext().getAttribute("nums");            
            bw.write(nums);            
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally{
            try {
                if(bw!=null){
                    bw.close();
                }
                if(fw!=null){
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }   
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
