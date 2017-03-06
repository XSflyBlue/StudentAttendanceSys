package com.xs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.xs.bean.ClassInfo;
import com.xs.dao.IClassInfoDao;
import com.xs.util.db.BeanHandler;
import com.xs.util.db.BeanListHandler;
import com.xs.util.db.DatabaseUtil;

public class ClassInfoDaoImpl implements IClassInfoDao{

	@Override
	public ClassInfo selectByPrimaryKey(Integer classId) {
		// TODO Auto-generated method stub
		String sql = "SELECT course_id,course_name FROM classinfo WHERE class_id=?";
		Object params[] = {classId};
		ClassInfo classinfo = null;
		try {
			classinfo = (ClassInfo)DatabaseUtil.query(sql,params,new BeanHandler(ClassInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classinfo ;
	}


	public List<ClassInfo> selectClassByTea(Integer teacherId) {
		String sql = "SELECT class_id,course_id,course_name FROM classinfo WHERE teacher_id=?";
		Object params[] = {teacherId};
		List<ClassInfo> classinfo = null;
		try {
			classinfo = (List<ClassInfo>)DatabaseUtil.query(sql,params,new BeanListHandler(ClassInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classinfo ;
	}
}
