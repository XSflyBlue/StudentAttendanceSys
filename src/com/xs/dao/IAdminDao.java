package com.xs.dao;

import java.util.List;

import com.xs.bean.Admin;

public interface IAdminDao {

    int insert(Admin record);
    
    int delete(Integer adminId);
   
    int updateByPrimaryKey(Admin record);
    
    Admin selectByPrimaryKey(Integer adminId);
   
    List<Admin> selectAll();
}