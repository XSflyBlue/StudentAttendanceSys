package com.xs.dao;

import java.util.List;

import com.xs.bean.AttendInfoMore;
import com.xs.bean.AttendanceInfo;
import com.xs.bean.Record;
import com.xs.bean.Student;
import com.xs.bean.Teacher;

public interface ITeacherDao {
	

    //修改教师邮箱
    int updateTeaEmail(Integer teacherId,String email);
    //修改教师密码
    int updateTeaPwd(Integer teacherId,String pwd);
    //修改教师个人信息
    int updateTea(Teacher record);
    //查看教师个人信息
    Teacher selectByPrimaryKey(Integer teacherId);
    //通过学生姓名查看学生信息
    List<Student> selectByStuname(Integer teacherId,String stuname);
    //通过学生id查看学生信息
    List<Student> selectByStuId(Integer teacherId,Integer studentId);
    //通过学生专业查看学生信息
    List<Student> selectByStuMajor(Integer teacherId,String stumajor);
    //通过班级号查看学生信息
    List<Student> selectByClassId(Integer teacherId,Integer classId);
    //录入考勤信息
    int insertAttendance(Record record,AttendanceInfo attend);
    //通过教师查看所有考勤信息
    List<AttendInfoMore> selectAttendByTea(Integer teacherId);
    //通过教师修改考勤信息
    int updateAttendBytea(AttendInfoMore attend);
    //教师通过搜索教学班得到考勤信息
    List<AttendInfoMore> selectAttendByClass(Integer teacherId,Integer classId);


}