package service;

import java.util.ArrayList;

import domain.Desp;
import utils.SqlHelper;

public class DespService {
	//add
	public static boolean addDesp(Desp desp) {
		boolean b=true;
		String sql="insert into desplib values(?);";
		String parameters[]= {desp.getDesp()};
//			System.out.println(parameters[0]);
		try {
			SqlHelper.executeUpdate(sql, parameters);
		} catch (Exception e) {
			b=false;
			e.printStackTrace();
		}
		return b;
		
	}
	
	//get 
	public ArrayList getDesp() {
		// TODO Auto-generated method stub
		ArrayList<Desp> al=new ArrayList<Desp>();
		//
		String sql="select * from desplib;";

		ArrayList al02=SqlHelper.executeQuery3(sql, null);
		//second package
		
		
		//package
		try {
			
			for(int i=0;i<al02.size();i++) {
				Object[] objs=(Object[])al02.get(i);
				Desp desp=new Desp();
				desp.setDesp(objs[0].toString());
				
				al.add(desp);
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return al;
		}
}
