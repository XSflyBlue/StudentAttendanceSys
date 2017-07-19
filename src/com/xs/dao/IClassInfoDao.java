package com.xs.dao;

import java.util.List;

import com.xs.bean.ClassInfo;

public interface IClassInfoDao {
    //镆ョ湅涓€涓绋嬩俊鎭?
    ClassInfo selectByPrimaryKey(Integer classId);
    //阃氲绷鏁椤笀镆ョ湅浠栨墍鎺堣镄勭彮绾?
    List<ClassInfo> selectClassByTea(Integer teacherId);
}