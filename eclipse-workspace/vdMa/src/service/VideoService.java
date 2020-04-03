package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Video;
import utils.SqlHelper;

public class VideoService {
	// getpage Count
		
		//add
		public static boolean addVideo(Video video) {
			boolean b=true;
			String sql="insert into videolib values(?,?,?,?,?,?,?);";
			String parameters[]= {video.getId(),video.getName(),video.getRight(),video.getDescp(),video.getWatchVolume()+"",video.getDate(),video.getUrl()};
			try {
				SqlHelper.executeUpdate(sql, parameters);
			} catch (Exception e) {
				b=false;
				e.printStackTrace();
			}
			return b;
			
			
		}
		
		//get 
		public ArrayList getVideo() {
			// TODO Auto-generated method stub
			ArrayList<Video> al=new ArrayList<Video>();
			//
			String sql="select * from videolib;";

			ArrayList al02=SqlHelper.executeQuery3(sql, null);
			//second package
			
			
			//package
			try {
				
				for(int i=0;i<al02.size();i++) {
					Object[] objs=(Object[])al02.get(i);
					Video video=new Video();
					video.setId(objs[0].toString());
					video.setName(objs[1].toString());
					video.setRight(objs[2].toString());
					video.setDescp(objs[3].toString());
					video.setWatchVolume(Integer.parseInt(objs[4].toString()));
					video.setDate(objs[5].toString());
					video.setUrl(objs[6].toString());
					
					al.add(video);
				}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return al;
		}

		//bypage
		public ArrayList getVideoByPage(int pageNow,int pageSize) {
			//create al
			ArrayList<Video> al=new ArrayList<Video>();
			//create sql
			String sql="select * from videolib  limit "+((pageNow-1)*pageSize)+","+pageSize+";";

			ArrayList al02=SqlHelper.executeQuery3(sql, null);
			//second package
			
			//package
			try {
				
				for(int i=0;i<al02.size();i++) {
					Object[] objs=(Object[])al02.get(i);
					Video video=new Video();
					video.setId(objs[0].toString());
					video.setName(objs[1].toString());
					video.setRight(objs[2].toString());
					video.setDescp(objs[3].toString());
					video.setWatchVolume(Integer.parseInt(objs[4].toString()));
					video.setDate(objs[5].toString());
					video.setUrl(objs[6].toString());
					
					al.add(video);
				}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return al;

			
		}
		
		//bypage
		public ArrayList getVideoByRight(int pageNow,int pageSize,String right) {
			//create al
			ArrayList<Video> al=new ArrayList<Video>();
			//create sql
			
			String sql="select * from videolib where vright = '"+right+"' limit "+((pageNow-1)*pageSize)+","+pageSize+";";

			ArrayList al02=SqlHelper.executeQuery3(sql, null);
			//second package
			
			//package
			try {
				
				for(int i=0;i<al02.size();i++) {
					Object[] objs=(Object[])al02.get(i);
					Video video=new Video();
					video.setId(objs[0].toString());
					video.setName(objs[1].toString());
					video.setRight(objs[2].toString());
					video.setDescp(objs[3].toString());
					video.setWatchVolume(Integer.parseInt(objs[4].toString()));
					video.setDate(objs[5].toString());
					video.setUrl(objs[6].toString());
					
					al.add(video);
				}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return al;

			
		}

}


/**


public static int getPageCount(int pageSize) {
			
			String sql="select count(*) from Videos";
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
		public ArrayList getVideoByPage(int pageNow,int pageSize) {
			ArrayList<Video> al=new ArrayList<Video>();
			//
			String sql="select * from Videos  limit "+((pageNow-1)*pageSize)+","+pageSize+";";
//			ResultSet rs=SqlHelper.executeQuery(sql, null);
			ArrayList al02=SqlHelper.executeQuery3(sql, null);
			//second package
			
			
			//package
			try {
				
				for(int i=0;i<al02.size();i++) {
					Object[] objs=(Object[])al02.get(i);
					Video Video=new Video();
					Video.setId(objs[0].toString());
					Video.setName(objs[1].toString());
					Video.setRight(objs[2].toString());
					
					Video.setDescp(objs[3].toString());
					Video.setWatchVolume(Integer.parseInt(objs[4].toString()));
					Video.setDate(objs[5].toString());
					Video.setUrl(objs[5].toString());
					
					al.add(Video);
				}

				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return al;
		}
		
		//use id get msg
		public static Video getVideoById(String id) {
			
			Video Video=new Video();
			String sql="select * from Videos where id=?";
			String parameters[]= {id};
			ResultSet rs=SqlHelper.executeQuery(sql, parameters);
			
			
			try {
				if(rs.next()) {
					Video.setId(rs.getString(1));
					Video.setName(rs.getString(2));
					Video.setRight(rs.getString(3));
					Video.setDescp(rs.getString(4));
					Video.setWatchVolume(rs.getInt(5));
					Video.setDate(rs.getString(6));
					Video.setUrl(rs.getString(7));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				SqlHelper.close(rs,SqlHelper.getPs(),SqlHelper.getCt());
				

			}
			return Video;
		}
		
		//change
		public static boolean updVideo(Video Video) {
			boolean b=true;
			String sql="update Videos set name=?, vright=?, grade=?, descp=?, watchVolume=?, date=?, url=? where id=?";
			String parameters[]= {Video.getName(),Video.getRight(),Video.getDescp(),Video.getWatchVolume()+"",Video.getDate(),Video.getUrl(), Video.getId()};
			try {
				SqlHelper.executeUpdate(sql, parameters);
			} catch (Exception e) {
				b=false;
				e.printStackTrace();
			}
			return b;
			
		}
		
		//delete
		public boolean delVideo(String id) {
			boolean b=true;
			String sql="delete from Videos where id=?";
			String parameters[]= {id};
			try {
				SqlHelper.executeUpdate(sql, parameters);
			} catch (Exception e) {
				b=false;
				e.printStackTrace();
			}
			return b;
			
			
		}



**/