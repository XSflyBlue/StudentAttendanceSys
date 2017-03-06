package com.xs.dao;

import java.util.List;

import com.xs.bean.Record;

public interface IRecordDao {
	int insert(Record record);
	
    int delete(Integer attendancerecordId);

    int updateByPrimaryKey(Record record);

    Record selectByPrimaryKey(Integer attendancerecordId);

    List<Record> selectAll();
}