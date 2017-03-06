package com.xs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.xs.bean.Faculty;
import com.xs.bean.Student;
import com.xs.dao.IFacultyDao;
import com.xs.util.db.BeanListHandler;
import com.xs.util.db.DatabaseUtil;

public class FacultyDaoImpl implements IFacultyDao{

	@Override
	public List<Faculty> selectAll() {
		String sql = "select * from facultyinfo";
		Object params[] = {};
		List<Faculty> faculty = null;
		try {
			faculty = (List<Faculty>)DatabaseUtil.query(sql,params,new BeanListHandler(Faculty.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return faculty  ;
	}

	

}
