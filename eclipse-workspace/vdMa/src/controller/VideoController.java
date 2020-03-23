package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Video;
import service.VideoService;

/**
 * Servlet implementation class VideoController
 */
@WebServlet("/VideoController")
public class VideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoController() {
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
	        
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String vright=request.getParameter("vright");
			String descp=request.getParameter("descp");
			String watchVolume=request.getParameter("watchVolume");
			String date=request.getParameter("date");
			String url=request.getParameter("url");
			
			//package
			Video video = new Video();
			video.setId(id);
			video.setName(name);
			video.setRight(vright);
			video.setDescp(descp);
			video.setWatchVolume(Integer.parseInt(watchVolume));
			video.setDate(date);
			video.setUrl(url);
			
			if(VideoService.addVideo(video)) {
				
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
