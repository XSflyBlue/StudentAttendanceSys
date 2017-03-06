package com.xs.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	// �������ݿ���������
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	// ���ݿ����ӵ�ַ
	private static final String DBURL = "jdbc:MySQL://localhost:3306/stuattendance";
	private static final String DBUSER = "root";
	private static final String DBPASS = "123456";
	private static final String DBNAME = "user";

	static {
		try {// ע������
			Class.forName(DBDRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	public static Connection getConnection() {
		Connection conn = null; // ����һ�����Ӷ���
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
		if (pstmt != null) { // ���pstmt Ԥ�������Ϊ��
			try {
				pstmt.close(); // �ر�pstmt Ԥ�������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(Statement stmt) {
		if (stmt != null) { // ���stmt �������Ϊ��
			try {
				stmt.close(); // �ر�stmt �������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void close(ResultSet rs) {
		if (rs != null) { // ���rs ���������Ϊnull
			try {
				rs.close(); // �ر�rs ���������
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}