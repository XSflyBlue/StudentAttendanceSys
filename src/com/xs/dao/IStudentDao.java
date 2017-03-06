package com.xs.dao;

import java.util.List;

import com.xs.bean.AttendInfoMore;
import com.xs.bean.ClassInfoMore;
import com.xs.bean.Student;
import com.xs.bean.TeacherInfo;

public interface IStudentDao {
    
    int insert(Student record);
    
    int delete(Integer studentId);
    //修改email
    int updateStuEmail(Integer studentId,String email);
    //修改密码
    int updateStuPwd(Integer studentId,String pwd);
    //修改个人信息  
    int updateByPrimaryKey(Student record);
    //查看个人信息
    Student selectByPrimaryKey(Integer studentId);
    //查看学生列表
    List<Student> selectAll();
    //通过学生查看教师信息
    List<TeacherInfo> selectTeacherBystuId(Integer studentId);
    //通过学生查看课程信息
    List<ClassInfoMore> selectClassBystuId(Integer studentId);
    //通过学生查询考勤结果
    List<AttendInfoMore> selectAttByclassId(Integer studentId,Integer class_id);
    //通过classid查看学生列表
    List<Student> selectStuByClass(Integer classId);
 
}