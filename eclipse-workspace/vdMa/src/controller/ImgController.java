package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Img;
import domain.Video;
import service.ImgService;
import service.VideoService;

/**
 * Servlet implementation class ImgController
 */
@WebServlet("/ImgController")
public class ImgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImgController() {
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
	
		//call service
		String type=request.getParameter("type");
		//add into db
		if("add".equals(type)) {
	        
			String url=request.getParameter("url");
			
			//package
			Img img = new Img();
			
			img.setUrl(url);
//			System.out.println(url);
			
			if(ImgService.addImg(img)) {
				
				request.getRequestDispatcher("/WEB-INF/info.jsp?info=addok").forward(request, response);

			}else {
				
				request.getRequestDispatcher("/WEB-INF/info.jsp?info=adderr").forward(request, response);
				
			}
			
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
