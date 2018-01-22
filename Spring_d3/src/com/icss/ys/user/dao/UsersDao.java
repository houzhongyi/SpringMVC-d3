package com.icss.ys.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.icss.ys.user.common.DBUtil;
import com.icss.ys.user.pojo.Users;
@Repository
public class UsersDao {
	/**
	 * 单个查询 SELECT
	 * @param username
	 * @return
	 */
	public Users queryByUsername(String username){
		Users s = null;
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		
		StringBuilder sql = new StringBuilder()
				.append("SELECT * ")
				.append("FROM users ")
				.append("WHERE username=?");
				
		try {
			st = conn.prepareStatement(sql.toString());
			st.setString(1, username);
			rs = st.executeQuery();
			if(rs.next()){
				s = new Users(rs.getString(1),rs.getString(2));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(st);
			DBUtil.close(conn);
		}		
		return s;
	}

	/**
	 * 插入数据 DML
	 */
	public int insertUser(Users user){
		Connection conn = null;
		PreparedStatement st = null;
	
		int i = 0;
		conn = DBUtil.getConn();
		try {
			st = conn.prepareStatement("INSERT INTO users VALUES(?,?)");
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			i = st.executeUpdate();
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(st);
			DBUtil.close(conn);
		}
		return i;
	}
	
	/**
	 * 查询所有用户
	 * @param args
	 */
	public ArrayList<Users> queryAllUsers(){
		ArrayList<Users> list = new ArrayList<Users>();
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		conn = DBUtil.getConn();
		
		StringBuilder sql = new StringBuilder()
				.append("SELECT * ")
				.append("FROM users ");
				
		try {
			st = conn.prepareStatement(sql.toString());
			
			rs = st.executeQuery();
			while(rs.next()){
				list.add(new Users(rs.getString(1),rs.getString(2)));
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(rs);
			DBUtil.close(st);
			DBUtil.close(conn);
		}		
		
		return list;
	}
	public static void main(String[] args) {
		List<Users> list = new UsersDao().queryAllUsers();
		for (Users users : list) {
			System.out.println(users);
		}
	}
}
