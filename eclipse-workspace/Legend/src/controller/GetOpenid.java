package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import domain.User;
import service.ParsingJson;
import service.UserService;



/**
 * Servlet implementation class GetOpenid
 */
@WebServlet("/GetOpenid")
public class GetOpenid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOpenid() {
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
		PrintWriter out = response.getWriter();
		
		String appid = "wx11fe45deb21ef577";
		String secret = "458772cc1a24952a648f75babc9a6bb5";
		String js_code = request.getParameter("code");
		String url = "https://api.weixin.qq.com/sns/jscode2session";
		String param = "appid="+appid+"&secret="+secret+"&js_code="+js_code+"&grant_type=authorization_code";
		//String myJson="{\"session_key\":\"EuXRWpgW1Kk4q\\/J8mDk6fw==\",\"openid\":\"oumfT5J3NLu8VMcUFHkJAYIMBgJM\"}";
		//new 
		UserService userService=new UserService();
		User user=new User();
		System.out.println("ok");
		//get user info from wechat
		try {  
			String result = service.SendHttps.sendGet(url, param);
			user = (User) ParsingJson.JsonTOObject(result);
			System.out.println(result);
			//check exist
			if(userService.checkExist(user)) {
				System.out.println("check ok");
			}else {			
				if(UserService.addUser(user)) {
					System.out.println("add ok");
				}else {
					System.out.println("add err");
				}
			}
			//get right
			user = UserService.getUserByOpenid(user.getOpenid());
			out.print(user.toJson());
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
