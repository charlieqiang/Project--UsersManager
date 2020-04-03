package service;

import java.util.ArrayList;

import domain.Img;
import domain.Video;
import utils.SqlHelper;

public class ImgService {

	//add
	public static boolean addImg(Img img) {
		boolean b=true;
		String sql="insert into imglib values(?);";
		String parameters[]= {img.getUrl()};
//		System.out.println(parameters[0]);
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
		
	}

	//get 
	public ArrayList getImg() {
		// TODO Auto-generated method stub
		ArrayList<Img> al=new ArrayList<Img>();
		//
		String sql="select * from imglib;";

		ArrayList al02=SqlHelper.executeQuery3(sql, null);
		//second package
		
		
		//package
		try {
			
			for(int i=0;i<al02.size();i++) {
				Object[] objs=(Object[])al02.get(i);
				Img img=new Img();
				img.setUrl(objs[0].toString());
				
				al.add(img);
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return al;
	}
	
}
