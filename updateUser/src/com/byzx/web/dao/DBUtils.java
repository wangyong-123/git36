package com.byzx.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.byzx.web.vo.User;

public class DBUtils {
	//获取数据库连接的方法
	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(DBInfo.JDBC_DRIVER);
			conn = DriverManager.getConnection(DBInfo.JDBC_URL, DBInfo.JDBC_USERNAME, DBInfo.JDBC_PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	//关流的方法
	public static void close(Connection conn,PreparedStatement ps,ResultSet rs) {//导包
		try {
			if(null != rs && !rs.isClosed()) {
				rs.close();
			}
			if(null != ps && !ps.isClosed()) {
				ps.close();
			}
			if(null != conn && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//user表的查询方法
	public static List<User> findUser (String sql){
		ResultSet rs = null;
		Connection conn =null;
		PreparedStatement ps = null;
		List<User> users = new ArrayList<User>();
		try {
			conn = getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setAge(rs.getInt("age"));
				user.setSex(rs.getString("sex"));
				user.setAddress(rs.getString("address"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,rs);
		}
		return users;
	}
	
	//表的增删改的方法
	public static int updateTable(String sql) {
		int updateRows = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		conn = getConn();
		try {
			ps = conn.prepareStatement(sql);
			updateRows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn,ps,null);
		}
		return updateRows;
	}
}
