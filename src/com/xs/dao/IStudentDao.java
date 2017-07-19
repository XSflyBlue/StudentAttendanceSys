package com.xs.dao;

import java.util.List;

import com.xs.bean.AttendInfoMore;
import com.xs.bean.ClassInfoMore;
import com.xs.bean.Student;
import com.xs.bean.TeacherInfo;

public interface IStudentDao {
    
    int insert(Student record);
    
    int delete(Integer studentId);
    //淇敼email
    int updateStuEmail(Integer studentId,String email);
    //淇敼瀵嗙爜
    int updateStuPwd(Integer studentId,String pwd);
    //淇敼涓汉淇℃伅  
    int updateByPrimaryKey(Student record);
    //镆ョ湅涓汉淇℃伅
    Student selectByPrimaryKey(Integer studentId);
    //镆ョ湅瀛︾敓鍒楄〃
    List<Student> selectAll();
    //阃氲绷瀛︾敓镆ョ湅鏁椤笀淇℃伅
    List<TeacherInfo> selectTeacherBystuId(Integer studentId);
    //阃氲绷瀛︾敓镆ョ湅璇剧▼淇℃伅
    List<ClassInfoMore> selectClassBystuId(Integer studentId);
    //阃氲绷瀛︾敓镆ヨ钥冨嫟缁撴灉
    List<AttendInfoMore> selectAttByclassId(Integer studentId,Integer class_id);
    //阃氲绷classid镆ョ湅瀛︾敓鍒楄〃
    List<Student> selectStuByClass(Integer classId);
 
}