package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Desp;
import domain.Img;
import domain.Video;
import service.DespService;
import service.ImgService;
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
		String type=request.getParameter("type");
		
		if("video".equals(type)) {
			
			String pageNowString=request.getParameter("pageNow");
			String right=request.getParameter("right");
			String pageSizeString=request.getParameter("pageSize");
			
			if(pageNowString!=null) {
				pageNow=Integer.parseInt(pageNowString);
			}
			
			if(pageSizeString!=null) {
				pageSize=Integer.parseInt(pageSizeString);
			}
			
			//new 
			VideoService videoService=new VideoService();
			
			ArrayList<Video> al = videoService.getVideoByRight(pageNow,pageSize,right);

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
			
		}else if ("img".equals(type)){
			//new 
			ImgService imgService=new ImgService();
			
			ArrayList<Img> ial = imgService.getImg();

			for(Img i:ial) {
				if(0==ial.indexOf(i)) {
					out.print("[{\"url\": \"https://legend.spe.kim/img/"+i.getUrl()
							+ "\"}");
					if((ial.size()-1)==ial.indexOf(i)) {
						out.println("]");
					}
				}else if ((ial.size()-1)==ial.indexOf(i)) {
					out.println(",{\"url\": \"https://legend.spe.kim/img/"+i.getUrl()
							+ "\"}]");
				}else {
					out.println(",{\"url\": \"https://legend.spe.kim/img/"+i.getUrl()
							+ "\"}");
				}
				
			}
			
		}else if ("desp".equals(type)){
			//new 
			DespService despService=new DespService();
			
			ArrayList<Desp> dal = despService.getDesp();

			for(Desp d:dal) {
					out.print("{\"desp\": \""+d.getDesp()
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
