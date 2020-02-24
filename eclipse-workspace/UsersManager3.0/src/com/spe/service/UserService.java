package com.spe.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.spe.domain.User;

public class UserService {
	Connection ct=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	String driver = "com.mysql.jdbc.Driver";
	String sql = "jdbc:mysql://localhost:3306/userdb?useSSL=false&serverTimezone=UTC";
	String sqluser = "root";
	String passwd = "123456";
	//check user
	public boolean checkUser(User user) {
		boolean b=false;
		
		try {
			//1.load driver
			Class.forName(driver);
			//2.get connetion
			ct=DriverManager.getConnection(sql,sqluser,passwd);
			//3.create preparedStatement
			ps = ct.prepareStatement("select * from users where id=? and passwd=?");
			//to ?
			ps.setObject(1, user.getId());
			ps.setObject(2, user.getPwd());
			//4.do it
			rs=ps.executeQuery();
			if(rs.next()) {
				b=true;
			
			}				
			
			
			//5.solve
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ps!=null)
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(ct!=null)
				try {
					ct.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return b;
		}
	}
