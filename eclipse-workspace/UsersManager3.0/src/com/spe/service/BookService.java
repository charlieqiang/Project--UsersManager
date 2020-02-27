package com.spe.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.spe.domain.Book;
import com.spe.domain.User;
import com.spe.utils.SqlHelper;

public class BookService {

	
	public ArrayList getBook() {
		ArrayList<Book> al=new ArrayList<Book>();
		//
		String sql="select * from books";
		ResultSet rs=SqlHelper.executeQuery(sql, null);
		//package
		try {
			while(rs.next()) {
				Book b=new Book();
				b.setId(rs.getString(1));
				b.setName(rs.getString(2));
				//
				al.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());

		}
		
		return al;
	}
}
