package com.icss.ys.user.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库的公共连接类
 * @author Administrator
 *
 */
public class DBUtil {
	private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user = "scott";
	private static String pass = "admin";
	// 1
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 2
	public static Connection getConn(){
		Connection c  = null;
		try {
			c = DriverManager.getConnection(url,user,pass);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return c;
	}
	//5
	public static void  close(Connection c){
		try {
			c.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void  close(Statement s){
		try {
			s.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void  close(ResultSet rs){
		try {
			rs.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
