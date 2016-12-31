package com.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	static Connection con=null;
	/*private static String url="jdbc:oracle:thin:@intvmoradb04:1521:ORAJAVADB";
	private static String username="TVM1617_TVM11_TJA58_DEV";
	private static String password="tcstvm1011";*/
	private static String url="jdbc:driver://myorcldb.ck58gn9qjoby.us-east-1.rds.amazonaws.com:1521/ORCL?user=admin&password=admin123";
	/*private static String username="admin";
	static String dbName = System.getenv("RDS_DB_NAME");
    static String userName = System.getenv("RDS_USERNAME");
    static String password = System.getenv("RDS_PASSWORD");
    static String hostname = System.getenv("RDS_HOSTNAME");
    static String port = System.getenv("RDS_PORT");*/
	//private static String password="admin123";
	static String dbName = "mysqldb";
    static String userName = "admin";
    static String password = "admin123";
    static String hostname = "mysqldb.ck58gn9qjoby.us-east-1.rds.amazonaws.com";
    static String port = "3306";
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		//	String jdbcUrl = "jdbc:mysql://mysqldb.ck58gn9qjoby.us-east-1.rds.amazonaws.com:3306/mysqldb?user=admin&password=admin123";
			String jdbcUrl = "jdbc:mysql://"+ hostname+":"+port+"/"+dbName+"?user="+userName+"&password="+password;   
		       con = DriverManager.getConnection(jdbcUrl);
			System.out.println("Connecting...!");
		//	con=DriverManager.getConnection(url,username,password);
		//	con=DriverManager.getConnection(url);
			System.out.println("Connection Established");
		
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	public static void closeConnection(Connection con){
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void closeStatement(PreparedStatement ps){
		if(ps!=null){
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
