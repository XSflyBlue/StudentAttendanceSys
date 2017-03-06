package com.xs.dao;

import java.util.List;

import com.xs.bean.ClassInfo;

public interface IClassInfoDao {
    //查看一个课程信息
    ClassInfo selectByPrimaryKey(Integer classId);
    //通过教师查看他所授课的班级
    List<ClassInfo> selectClassByTea(Integer teacherId);
}