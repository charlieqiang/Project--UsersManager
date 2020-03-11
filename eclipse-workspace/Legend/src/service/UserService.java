package service;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.User;
import util.SqlHelper;



public class UserService {

	public boolean checkExist(User user) {
		boolean b=false;
		//use sql helper
		String sql="select * from users where openid=?";
		String parameters[]= {user.getOpenid()};
		
//		ResultSet rs=SqlHelper.executeQuery(sql,parameters);
		ArrayList al = SqlHelper.executeQuery3(sql, parameters);
		
		//check 
		try {
			if(al.size()==1) {
				b=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
//			SqlHelper.close(al,SqlHelper.getPs(),SqlHelper.getCt());
		}
		
		return b;
	}

	public static boolean addUser(User user) {
		boolean b=true;
		String sql="insert into users (openid,session_key) values(?,?)";
		String parameters[]= {user.getOpenid(),user.getSession_key()};
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
	}
	//use id get msg
	public static User getUserByOpenid(String openid) {
		
		User user=new User();
		String sql="select * from users where openid=?";
		String parameters[]= {openid};
		ResultSet rs=SqlHelper.executeQuery(sql, parameters);
		
		
		try {
			if(rs.next()) {
				user.setOpenid(rs.getString(1));
				user.setUserRight(rs.getString(2));
				user.setSession_key(rs.getString(3));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
		}
		return user;
	}
}
