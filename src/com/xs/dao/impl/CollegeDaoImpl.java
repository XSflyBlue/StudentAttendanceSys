package com.xs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.xs.bean.College;
import com.xs.bean.Faculty;
import com.xs.dao.ICollegeDao;
import com.xs.util.db.BeanListHandler;
import com.xs.util.db.DatabaseUtil;

public class CollegeDaoImpl implements ICollegeDao{

	@Override
	public List<College> selectAll() {
		String sql = "select * from collegeinfo";
		Object params[] = {};
		List<College> college = null;
		try {
			college = (List<College>)DatabaseUtil.query(sql,params,new BeanListHandler(College.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return college  ;
	}

	
}
