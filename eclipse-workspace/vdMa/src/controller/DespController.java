package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Desp;
import domain.Img;
import service.DespService;
import service.ImgService;

/**
 * Servlet implementation class DespController
 */
@WebServlet("/DespController")
public class DespController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DespController() {
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
	
		//add into db
		
	        
		String despString=request.getParameter("desp");
		
		//package
		Desp desp = new Desp();
		
		desp.setDesp(despString);

		if(DespService.addDesp(desp)) {
			
			request.getRequestDispatcher("/WEB-INF/info.jsp?info=addok").forward(request, response);

		}else {
			
			request.getRequestDispatcher("/WEB-INF/info.jsp?info=adderr").forward(request, response);
			
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
