package com.spe.service;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spe.domain.User;
import com.spe.utils.SqlHelper;

public class UserService {
	// getpage Count
	public static int getPageCount(int pageSize) {
		
		String sql="select count(*) from users";
		ResultSet rs=SqlHelper.executeQuery(sql, null);
		int rowCount=0;
		try {
			rs.next();
			rowCount=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
			
		}
		
		return (rowCount-1)/pageSize+1;
		
	}
	
	//page service
	public ArrayList getUserByPage(int pageNow,int pageSize) {
		ArrayList<User> al=new ArrayList<User>();
		//
		String sql="select * from users  limit "+((pageNow-1)*pageSize)+","+pageSize+";";
		ResultSet rs=SqlHelper.executeQuery(sql, null);
		//package
		try {
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setGrade(rs.getInt(4));
				//
				al.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());

		}
		
		return al;
	}
	//use id get msg
	public static User getUserById(String id) {
		
		User user=new User();
		String sql="select * from users where id=?";
		String parameters[]= {id};
		ResultSet rs=SqlHelper.executeQuery(sql, parameters);
		try {
			if(rs.next()) {
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setGrade(rs.getInt(4));
				user.setPwd(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
			

		}
		return user;
	}
	//add
	public static boolean addUser(User user) {
		boolean b=true;
		String sql="insert into users values(null,?,?,?,?)";
		String parameters[]= {user.getName(),user.getEmail(),user.getGrade()+"",user.getPwd()	};
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
		
		
	}
	//change
	public static boolean updUser(User user) {
		boolean b=true;
		String sql="update users set username=?, email=?, grade=?, passwd=? where id=?";
		String parameters[]= {user.getName(),user.getEmail(),user.getGrade()+"",user.getPwd(),user.getId()+""};
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
		
		
	}
	//delete
	public boolean delUser(String id) {
		boolean b=true;
		String sql="delete from users where id=?";
		String parameters[]= {id};
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
		
		
	}
	//check user
	public boolean checkUser(User user) {
		boolean b=false;
		//use sql helper
		String sql="select * from users where id=? and passwd=?";
		String parameters[]= {user.getId()+"",user.getPwd()};
		
		ResultSet rs=SqlHelper.executeQuery(sql,parameters);
		//check 
		try {
			if(rs.next()) {
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
		}
		
		return b;
	}
}
