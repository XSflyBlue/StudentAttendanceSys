package com.xs.dao;

import java.util.List;

import com.xs.bean.AttendanceInfo;

public interface IAttendanceInfoDao {

    int insert(AttendanceInfo record);

    int delete(Integer attendanceId);
    
    int updateByPrimaryKey(AttendanceInfo record);
    
    AttendanceInfo selectByPrimaryKey(Integer attendanceId);

    List<AttendanceInfo> selectAll();
}