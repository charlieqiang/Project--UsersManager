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
	public int getPageCount(int pageSize) {
		
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
