package com.xs.bean;

public class TeacherInfo extends Teacher {

	private String course_name;

	private Integer teacher_id;

	private String teacher_name;

	private String teacher_login_pwd;

	private String teacher_email;

	private String college_name;

	private String faculty_name;

	public Integer getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Integer teacher_id) {
		this.teacher_id = teacher_id;
	}

	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}



	public String getTeacher_login_pwd() {
		return teacher_login_pwd;
	}

	public void setTeacher_login_pwd(String teacher_login_pwd) {
		this.teacher_login_pwd = teacher_login_pwd;
	}

	public String getTeacher_email() {
		return teacher_email;
	}

	public void setTeacher_email(String teacher_email) {
		this.teacher_email = teacher_email;
	}

	public String getCollege_name() {
		return college_name;
	}

	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}

	public String getFaculty_name() {
		return faculty_name;
	}

	public void setFaculty_name(String faculty_name) {
		this.faculty_name = faculty_name;
	}
	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}




}
