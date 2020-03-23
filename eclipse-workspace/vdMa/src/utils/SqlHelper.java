/**
 * @Description crud
 * @author Charlie
 * @date 2020-02-08 14:01
 */
package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.Callable;
import javax.management.RuntimeErrorException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class SqlHelper {
	
	//define
	private static Connection ct=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	private static CallableStatement cs=null;
	
	
	private static String driver = "";
	private static String url = "";
	private static String username = "";
	private static String password = "";
	
	private static Properties pp=null;
	private static InputStream fis=null;
	
	static {
		// TODO Auto-generated constructor stub
		try {
			
			pp=new Properties();
//			fis=new FileInputStream("dbinfo.properties");
			//classloader
			fis=SqlHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties"); 	
			
			pp.load(fis);
			url=pp.getProperty("url");
			username=pp.getProperty("username");
			driver=pp.getProperty("driver");
			password=pp.getProperty("password");
			
			Class.forName(driver);
			
//			ct=DriverManager.getConnection(url,username,password);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			fis=null;
		}
	}
	//connect
	public static Connection getConnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(driver);
			ct=DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ct;
	
	}

	//only one crud
	public static void executeUpdate(String sql, String[] parameters) {
		try {
			ct=getConnection();
			
			ps=ct.prepareStatement(sql);
			//add
			
			if(parameters!=null) {
				for(int i=0;i<parameters.length;i++) {
					ps.setString(i+1, parameters[i]);
			
				}
			}
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(rs, ps, ct);
		}
		

	}
	
	//only one crud
	public static ArrayList executeQuery3(String sql, String[] parameters) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet inrs = null;
		
		try {
			conn=getConnection();
			
			pstmt=conn.prepareStatement(sql);
			
			if(parameters!=null&&!parameters.equals("")) {
				for(int i=0;i<parameters.length;i++) {
					pstmt.setObject(i+1, parameters[i]);
				}
			}
			inrs = pstmt.executeQuery();
			ArrayList al = new ArrayList();
			ResultSetMetaData rsmd = (ResultSetMetaData) inrs.getMetaData();
			int column = rsmd.getColumnCount();

			while(inrs.next()) {
				Object[] ob = new Object[column];
				for (int i = 1;i<=column;i++) {
					ob[i-1]=inrs.getObject(i);
				}
				al.add(ob);
			}

			return al;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(inrs, pstmt, conn);
		
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement ps, Connection ct) {
		// TODO Auto-generated method stubpublic void close(ResultSet rs,CallableStatement cs,Connection ct) {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static Connection getCt() {
		return ct;
	}
	
	public static PreparedStatement getPs() {
		return ps;
	}
	
	public static ResultSet getRs() {
		return rs;
	}
	
	public static CallableStatement getCs() {
		return cs;
	}
}


/**

	//分页
	public static ResultSet executeQuery2() {
		return null;
	}
	
	
	
	//call sql store2
	public static CallableStatement callPro2(String sql, String[] inparameters,Integer[] outparameters) {
		
		boolean b=true;
		try {
			ct=getConnection();
			cs=ct.prepareCall(sql);
			if(inparameters!=null) {
				for(int i=0;i<inparameters.length;i++) {
					cs.setObject(i+1, inparameters[i]);
			
				}
			}
			
			//out
			if(outparameters!=null) {
				for(int i=0;i<outparameters.length;i++) {
					cs.registerOutParameter(inparameters.length, outparameters[i]);
			
				}
			}
			cs.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		return cs;
		
	}
	
	//call sql store
	public static void callPro1(String sql, String[] parameters) {
		
		try {
			ct=getConnection();
			cs=ct.prepareCall(sql);
			
			if(parameters!=null) {
				for(int i=0;i<parameters.length;i++) {
					cs.setObject(i+1, parameters[i]);
			
				}
			}
			
			cs.execute();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			close(rs,cs,ct);
		}
		
	}
	//only one crud
	public static ResultSet executeQuery(String sql, String[] parameters) {
		try {
			ct=getConnection();
			ps=ct.prepareStatement(sql);
			//add
			
			if(parameters!=null&&!parameters.equals("")) {
				for(int i=0;i<parameters.length;i++) {
					ps.setString(i+1, parameters[i]);
			
				}
			}
			rs=ps.executeQuery();
			
//				for(int i=0;i<paras.length;i++) {
//					ps.setString(i+1, paras[i]);
//					
//				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
//				close(rs, ps, ct);
		}
		return rs;
	}
	
	//考虑事物的crud
	public static void executeUpdate2(String sql[],String [][]parameters) {
		try {
			//核心
			
			ct=getConnection();
			//may have many
			ct.setAutoCommit(false);
			//add
			for(int i=0;1<sql.length;i++) {
				if(parameters[i]!=null) {
					ps=ct.prepareStatement(sql[i]);
					for(int j=0;j<parameters[i].length;i++) {
						ps.setString(i+1, parameters[i][j]);
				
					}
					ps.executeUpdate();
				}
			}
			ct.commit();
			
//				for(int i=0;i<paras.length;i++) {
//					ps.setString(i+1 paras[i]);
//					
//				}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//back
			try {
				ct.rollback();
			} catch (SQLException e2) {
				// TODO: handle exception
				e2.printStackTrace();
				throw new RuntimeException(e.getMessage());
				
			}
			
		} finally {
			close(rs, ps, ct);
		}

	}
		



**/