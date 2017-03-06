package com.xs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.xs.bean.AttendInfoMore;
import com.xs.bean.ClassInfoMore;
import com.xs.bean.Student;
import com.xs.dao.IStudentDao;
import com.xs.bean.TeacherInfo;
import com.xs.util.db.BeanHandler;
import com.xs.util.db.BeanListHandler;
import com.xs.util.db.DatabaseUtil;

public class StudentDaoImpl implements IStudentDao{

	@Override
	public int delete(Integer studentId) {
		String sql = "delete from studentinfo where student_id=?";
		Object params[] = { studentId };
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int insert(Student record) {
		String sql = "insert into studentinfo(student_id,student_name,student_login_pwd,student_college,student_major,student_email) values(?,?,?,?,?,?)";
		Object params[] = {record.getStudent_id(),record.getStudent_name(),
				record.getStudent_login_pwd(),record.getStudent_college(),
				record.getStudent_major(),record.getStudent_email()};
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public Student selectByPrimaryKey(Integer studentId) {
		String sql = "select * from studentinfo where student_id=?";
        Object params[] = {studentId};
        Student student = null;
        try {
        	student = (Student) DatabaseUtil.query(sql, params, new BeanHandler(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		String sql = "update account set student_name=?,student_login_pwd=?,student_college=?,student_major=?,student_email=? where student_id=?";
		Object params[] = {record.getStudent_name(),record.getStudent_login_pwd(),
				record.getStudent_college(),record.getStudent_major(),
				record.getStudent_email(),record.getStudent_id()};
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> selectAll() {
		String sql = "select * from studentinfo";
		Object params[] = {};
		List<Student> student = null;
		try {
			student = (List<Student>)DatabaseUtil.query(sql,params,new BeanListHandler(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return student ;
	}

	@Override
	public  List<TeacherInfo> selectTeacherBystuId(Integer studentId){
		String sql="select A.teacher_name,B.course_name,A.college_name from teacherinfo as A,classinfo as B, classstudentinfo AS C WHERE "
				+ "C.student_id=? and C.class_id=B.class_id and  B.teacher_id=A.teacher_id";
		Object params[]={studentId};
		List<TeacherInfo> teachers = null;
		try {
			teachers = (List<TeacherInfo>)DatabaseUtil.query(sql,params,new BeanListHandler(TeacherInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teachers ;
	}

	@Override
	public List<ClassInfoMore> selectClassBystuId(Integer studentId){
		String sql="SELECT A.course_name,A.class_time ,A.class_end_week,B.teacher_name FROM classinfo as A ,teacherinfo as B,classstudentinfo as C "
				+ "WHERE A.teacher_id=B.teacher_id and C.class_id=A.class_id and C.student_id=?";
		Object params[]={studentId};
		List<ClassInfoMore> classinfo= null;
		try {
			classinfo= (List<ClassInfoMore>)DatabaseUtil.query(sql,params,new BeanListHandler(ClassInfoMore.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classinfo ;
	}

	@Override
	public List<AttendInfoMore> selectAttByclassId(Integer studentId,
			Integer class_id) {
		String sql="SELECT A.record_time,B.attendance_status,C.course_name FROM attendanceinfo as A,attendancerecord as B, classinfo as C "
				+ "WHERE A.class_id=C.class_id and A.attendance_id=B.attendance_id and B.student_id=? and A.class_id=?";
		Object params[]={studentId,class_id};
		List<AttendInfoMore> attend= null;
		try {
			attend= (List<AttendInfoMore>)DatabaseUtil.query(sql,params,new BeanListHandler(AttendInfoMore.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attend ;
	}

	@Override
	public int updateStuEmail(Integer studentId,String email) {
		String sql = "update studentinfo set student_email=? WHERE student_id=?";
		Object params[] = {email,studentId};
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int updateStuPwd(Integer studentId,String pwd) {
		String sql = "update studentinfo set student_login_pwd=? WHERE student_id=?";
		Object params[] = {pwd,studentId};
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public List<Student> selectStuByClass(Integer classId) {
		String sql="SELECT A.student_id,A.student_name FROM studentinfo as A,classstudentinfo as B "
				+ "WHERE A.student_id=B.student_id AND B.class_id=?";
		Object params[]={classId};
		List<Student> student= null;
		try {
			student= (List<Student>)DatabaseUtil.query(sql,params,new BeanListHandler(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student ;
	}
	
}
