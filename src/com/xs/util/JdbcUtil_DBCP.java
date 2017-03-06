package com.xs.util;

import java.io.IOException;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
* @ClassName: JdbcUtil_DBCP
* @Description: 数据库连接工具类
*
*/ 
public class JdbcUtil_DBCP {
    /**
     * 在java中，编写数据库连接池需实现java.sql.DataSource接口，每一种数据库连接池都是DataSource接口的实现
     * DBCP连接池就是javax.sql.DataSource接口的一个具体实现
     */
    private static DataSource ds = null;
    //在静态代码块中创建数据库连接池
    static{
            //加载dbcpconfig.properties配置文件
        	InputStream in = JdbcUtil_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties prop = new Properties();
            try {
				prop.load(in);
				//创建数据源
				ds = BasicDataSourceFactory.createDataSource(prop);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
    }
    
    /**
    * @Method: getConnection
    * @Description: 从数据源中获取数据库连接
    * @return Connection
    * @throws SQLException
    */ 
    public static Connection getConnection() throws SQLException{
        //从数据源中获取数据库连接
        return ds.getConnection();
    }
    
    /**
    * @Method: close
    * @Description: 释放资源，
    * 释放的资源包括Connection数据库连接对象，负责执行SQL命令的Statement对象，存储查询结果的ResultSet对象
    *
    * @param conn
    */ 
    public static void close(Connection conn){
        if(conn!=null){
            try{
                //将Connection连接对象还给数据库连接池
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
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