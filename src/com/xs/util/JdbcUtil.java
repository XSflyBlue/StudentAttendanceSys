package com.xs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	// 定义数据库驱动程序
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	// 数据库连接地址
	private static final String DBURL = "jdbc:MySQL://localhost:3306/stuattendance";
	private static final String DBUSER = "root";
	private static final String DBPASS = "123456";
	private static final String DBNAME = "user";

	static {
		try {// 注册驱动
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public static Connection getConnection() {
		Connection conn = null; // 声明一个连接对象
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	public static void close(PreparedStatement pstmt) {
		if (pstmt != null) { // 如果pstmt 预处理对象不为空
			try {
				pstmt.close(); // 关闭pstmt 预处理对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) { // 如果stmt 处理对象不为空
			try {
				stmt.close(); // 关闭stmt 处理对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) { // 如果rs 结果集对象不为null
			try {
				rs.close(); // 关闭rs 结果集对象
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}