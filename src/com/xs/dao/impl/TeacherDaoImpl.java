package com.xs.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.xs.bean.AttendInfoMore;
import com.xs.bean.AttendanceInfo;
import com.xs.bean.ClassInfo;
import com.xs.bean.Record;
import com.xs.bean.Student;
import com.xs.bean.Teacher;
import com.xs.dao.ITeacherDao;
import com.xs.util.db.BeanHandler;
import com.xs.util.db.BeanListHandler;
import com.xs.util.db.DatabaseUtil;

public class TeacherDaoImpl implements ITeacherDao{



	@Override
	public Teacher selectByPrimaryKey(Integer teacherId) {
		String sql = "select * from teacherinfo where teacher_id=?";
        Object params[] = {teacherId};
        Teacher teacher = null;
        try {
        	teacher  = (Teacher) DatabaseUtil.query(sql, params, new BeanHandler(Teacher.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teacher ;
	}


	@Override
	public int updateTeaEmail(Integer teacherId, String email) {
		String sql = "update teacherinfo set teacher_email=? WHERE teacher_id=?";
		Object params[] = {email,teacherId};
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int updateTeaPwd(Integer teacherId, String pwd) {
		String sql = "update teacherinfo set teacher_login_pwd=? WHERE teacher_id=?";
		Object params[] = {pwd,teacherId};
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public int updateTea(Teacher record) {
		String sql = "update teacherinfo SET teacher_email=?,college_name=?,faculty_name=? WHERE teacher_id=?";
		Object params[] = {record.getTeacher_email(),record.getCollege_name(),record.getFaculty_name(),record.getTeacher_id()};
		try {
			return DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Student> selectByStuname(Integer teacherId, String stuname) {
		String sql = "SELECT A.student_college,A.student_id,A.student_major,A.student_name FROM studentinfo as A,classinfo as B,classstudentinfo as C "
				+ "WHERE C.student_id=A.student_id and C.class_id=B.class_id AND B.teacher_id=? AND A.student_name=?";
		Object params[] = {teacherId,stuname};
		List<Student> student = null;
		try {
			student = (List<Student>)DatabaseUtil.query(sql,params,new BeanListHandler(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student ;
	}
	@Override
	public List<Student> selectByStuId(Integer teacherId,Integer studentId) {
		String sql = "SELECT A.student_college,A.student_id,A.student_major,A.student_name FROM studentinfo as A,classinfo as B,classstudentinfo as C "
				+ "WHERE C.student_id=A.student_id and C.class_id=B.class_id AND B.teacher_id=? AND A.student_id=?";
		Object params[] = {teacherId,studentId};
		List<Student> student = null;
		try {
			student = (List<Student>)DatabaseUtil.query(sql,params,new BeanListHandler(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student ;
	}
	@Override
	public List<Student> selectByStuMajor(Integer teacherId,String stumajor){
		String sql = "SELECT A.student_college,A.student_id,A.student_major,A.student_name FROM studentinfo as A,classinfo as B,classstudentinfo as C "
				+ "WHERE C.student_id=A.student_id and C.class_id=B.class_id AND B.teacher_id=? AND A.student_major=?";
		Object params[] = {teacherId,stumajor};
		List<Student> student = null;
		try {
			student = (List<Student>)DatabaseUtil.query(sql,params,new BeanListHandler(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student ;
	}
	@Override
	public List<Student> selectByClassId(Integer teacherId,Integer classId) {
		String sql = "SELECT A.student_college,A.student_id,A.student_major,A.student_name FROM studentinfo as A,classinfo as B,classstudentinfo as C "
				+ "WHERE C.student_id=A.student_id and C.class_id=B.class_id AND B.teacher_id=? AND B.class_id=?";
		Object params[] = {teacherId,classId};
		List<Student> student = null;
		try {
			student = (List<Student>)DatabaseUtil.query(sql,params,new BeanListHandler(Student.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return student ;
	}

	@Override
	public int insertAttendance(Record record, AttendanceInfo attend) {
		String sql1 = "INSERT INTO attendanceinfo(class_id,record_time) VALUES(?,?) ";
		String sql2 = "insert into attendancerecord(attendance_id,student_id,attendance_status)  VALUES((select LAST_INSERT_ID()),?,?)";
		Object params1[] = {attend.getClass_id(),attend.getRecord_time()};
		Object params2[] = {record.getStudent_id(),record.getAttendance_status()};
		try {
			DatabaseUtil.update(sql1, params1);
			DatabaseUtil.update(sql2, params2);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public List<AttendInfoMore> selectAttendByTea(Integer teacherId) {
		String sql = "SELECT A.student_id,A.student_name,B.class_id,B.course_name,C.record_time,D.attendance_status,D.attendanceRecord_id  "
				+ "FROM studentinfo as A,classinfo AS B, attendanceinfo AS C,attendancerecord AS D "
				+ "WHERE B.class_id=C.class_id AND C.attendance_id=D.attendance_id AND D.student_id=A.student_id and B.teacher_id=?";
		Object params[] = {teacherId};
		List<AttendInfoMore> attend = null;
		try {
			attend = (List<AttendInfoMore>)DatabaseUtil.query(sql,params,new BeanListHandler(AttendInfoMore.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attend ;
	}

	@Override
	public int updateAttendBytea(AttendInfoMore attend) {
		String sql = "UPDATE attendancerecord SET attendance_status=? "
				+ "where attendanceRecord_id=?";
		Object params[] = {attend.getAttendance_status(),attend.getAttendanceRecord_id()};
		try {
			DatabaseUtil.update(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}

	@Override
	public List<AttendInfoMore> selectAttendByClass(Integer teacherId,
													Integer classId) {
		String sql = "SELECT distinct A.student_id,A.student_name,B.class_id,B.course_name,C.record_time,D.attendance_status "
				+ "FROM studentinfo as A,classinfo AS B, attendanceinfo AS C,attendancerecord AS D "
				+ "WHERE B.class_id=C.class_id AND C.attendance_id=D.attendance_id AND D.student_id=A.student_id and B.teacher_id=?  AND B.class_id=?";
		Object params[] = {teacherId,classId};
		List<AttendInfoMore> attend = null;
		try {
			attend = (List<AttendInfoMore>)DatabaseUtil.query(sql,params,new BeanListHandler(AttendInfoMore.class));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return attend ;
	}








}
