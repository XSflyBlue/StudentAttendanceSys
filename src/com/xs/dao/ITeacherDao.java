package com.xs.dao;

import java.util.List;

import com.xs.bean.AttendInfoMore;
import com.xs.bean.AttendanceInfo;
import com.xs.bean.Record;
import com.xs.bean.Student;
import com.xs.bean.Teacher;

public interface ITeacherDao {
	

    //�޸Ľ�ʦ����
    int updateTeaEmail(Integer teacherId,String email);
    //�޸Ľ�ʦ����
    int updateTeaPwd(Integer teacherId,String pwd);
    //�޸Ľ�ʦ������Ϣ
    int updateTea(Teacher record);
    //�鿴��ʦ������Ϣ
    Teacher selectByPrimaryKey(Integer teacherId);
    //ͨ��ѧ�������鿴ѧ����Ϣ
    List<Student> selectByStuname(Integer teacherId,String stuname);
    //ͨ��ѧ��id�鿴ѧ����Ϣ
    List<Student> selectByStuId(Integer teacherId,Integer studentId);
    //ͨ��ѧ��רҵ�鿴ѧ����Ϣ
    List<Student> selectByStuMajor(Integer teacherId,String stumajor);
    //ͨ���༶�Ų鿴ѧ����Ϣ
    List<Student> selectByClassId(Integer teacherId,Integer classId);
    //¼�뿼����Ϣ
    int insertAttendance(Record record,AttendanceInfo attend);
    //ͨ����ʦ�鿴���п�����Ϣ
    List<AttendInfoMore> selectAttendByTea(Integer teacherId);
    //ͨ����ʦ�޸Ŀ�����Ϣ
    int updateAttendBytea(AttendInfoMore attend);
    //��ʦͨ��������ѧ��õ�������Ϣ
    List<AttendInfoMore> selectAttendByClass(Integer teacherId,Integer classId);


}