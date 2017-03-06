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
* @Description: ���ݿ����ӹ�����
*
*/ 
public class JdbcUtil_DBCP {
    /**
     * ��java�У���д���ݿ����ӳ���ʵ��java.sql.DataSource�ӿڣ�ÿһ�����ݿ����ӳض���DataSource�ӿڵ�ʵ��
     * DBCP���ӳؾ���javax.sql.DataSource�ӿڵ�һ������ʵ��
     */
    private static DataSource ds = null;
    //�ھ�̬������д������ݿ����ӳ�
    static{
            //����dbcpconfig.properties�����ļ�
        	InputStream in = JdbcUtil_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties prop = new Properties();
            try {
				prop.load(in);
				//��������Դ
				ds = BasicDataSourceFactory.createDataSource(prop);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Throwable e) {
				e.printStackTrace();
			}
    }
    
    /**
    * @Method: getConnection
    * @Description: ������Դ�л�ȡ���ݿ�����
    * @return Connection
    * @throws SQLException
    */ 
    public static Connection getConnection() throws SQLException{
        //������Դ�л�ȡ���ݿ�����
        return ds.getConnection();
    }
    
    /**
    * @Method: close
    * @Description: �ͷ���Դ��
    * �ͷŵ���Դ����Connection���ݿ����Ӷ��󣬸���ִ��SQL�����Statement���󣬴洢��ѯ�����ResultSet����
    *
    * @param conn
    */ 
    public static void close(Connection conn){
        if(conn!=null){
            try{
                //��Connection���Ӷ��󻹸����ݿ����ӳ�
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
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