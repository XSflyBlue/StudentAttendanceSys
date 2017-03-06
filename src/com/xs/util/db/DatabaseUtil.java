package com.xs.util.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xs.util.JdbcUtil_DBCP;

public class DatabaseUtil {

	public static int update(String sql, Object params[]) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil_DBCP.getConnection();
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
			return pstmt.executeUpdate();

		} finally {
			JdbcUtil_DBCP.close(rs);
			JdbcUtil_DBCP.close(pstmt);
			JdbcUtil_DBCP.close(conn);
		}
	}
	
public static Object query(String sql,Object params[],ResultSetHandler rsh) throws SQLException{
        
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try{
            conn = JdbcUtil_DBCP.getConnection();;
            pstmt = conn.prepareStatement(sql);
            for(int i=0;i<params.length;i++){
            	pstmt.setObject(i+1, params[i]);
            }
            rs = pstmt.executeQuery();
            /**
             * 对于查询返回的结果集处理使用到了策略模式
             */
            return rsh.handler(rs);
            
        }finally{
        	JdbcUtil_DBCP.close(rs);
			JdbcUtil_DBCP.close(pstmt);
        	JdbcUtil_DBCP.close(conn);
        }
    }
}
