package com.xs.bean;

public class AttendInfoMore extends Record {

	private String record_time;
	
	private String course_name;
	
	private Integer class_id;
	
	private Integer attendanceRecord_id;

    private Integer attendance_id;

    private Integer student_id;
    
    private String student_name;
    private String attendance_status;

	public String getRecord_time() {
		return record_time;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	public void setRecord_time(String record_time) {
		this.record_time = record_time;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getAttendance_status() {
		return attendance_status;
	}

	public void setAttendance_status(String attendance_status) {
		this.attendance_status = attendance_status;
	}

	public Integer getAttendanceRecord_id() {
		return attendanceRecord_id;
	}

	public void setAttendanceRecord_id(Integer attendanceRecord_id) {
		this.attendanceRecord_id = attendanceRecord_id;
	}

	public Integer getAttendance_id() {
		return attendance_id;
	}

	public void setAttendance_id(Integer attendance_id) {
		this.attendance_id = attendance_id;
	}

	public Integer getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	public Integer getClass_id() {
		return class_id;
	}

	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	
	
}
