package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Video;
import service.VideoService;

/**
 * Servlet implementation class ApiController
 */
@WebServlet("/ApiController")
public class ApiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApiController() {
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
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//set page
		int pageNow=1;
		int pageSize=5;
//		int pageCount=1;
		
		//get request
		String pageNowString=request.getParameter("pageNow");
		
		if(pageNowString!=null) {
			pageNow=Integer.parseInt(pageNowString);
		}
		
		//new 
		VideoService videoService=new VideoService();
		
		ArrayList<Video> al = videoService.getVideoByPage(pageNow,pageSize);

		for(Video v:al) {
			if(0==al.indexOf(v)) {
				
				out.print("[{\"id\":\"https://legend.spe.kim/video/"+ v.getId()+
						"\",\"name\": \""+v.getName()
						+ "\",\"vright\": \""+v.getRight()
						+ "\",\"descp\": \""+v.getDescp()
						+ "\",\"watchVolume\": \""+v.getWatchVolume()
						+ "\",\"date\": \""+v.getDate()
						+ "\",\"url\": \"https://legend.spe.kim/image/"+v.getUrl()
						+ "\"}");
				if((al.size()-1)==al.indexOf(v)) {
					out.println("]");
				}
			}else if ((al.size()-1)==al.indexOf(v)) {
				out.println(",{\"id\":\"https://legend.spe.kim/video/"+ v.getId()+
						"\",\"name\": \""+v.getName()
						+ "\",\"vright\": \""+v.getRight()
						+ "\",\"descp\": \""+v.getDescp()
						+ "\",\"watchVolume\": \""+v.getWatchVolume()
						+ "\",\"date\": \""+v.getDate()
						+ "\",\"url\": \"https://legend.spe.kim/image/"+v.getUrl()
						+ "\"}]");
			}else {
				out.println(",{\"id\":\"https://legend.spe.kim/video/"+ v.getId()+
						"\",\"name\": \""+v.getName()
						+ "\",\"vright\": \""+v.getRight()
						+ "\",\"descp\": \""+v.getDescp()
						+ "\",\"watchVolume\": \""+v.getWatchVolume()
						+ "\",\"date\": \""+v.getDate()
						+ "\",\"url\": \"https://legend.spe.kim/image/"+v.getUrl()
						+ "\"}");
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
