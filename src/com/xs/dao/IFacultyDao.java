package com.xs.dao;

import java.util.List;

import com.xs.bean.Faculty;

public interface IFacultyDao {

    //查看所有科 系
    List<Faculty> selectAll();
}