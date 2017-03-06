package com.xs.dao;

import java.util.List;

import com.xs.bean.College;

public interface ICollegeDao {

    //查看所有学院 
    List<College> selectAll();
}