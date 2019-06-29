package com.example.demo.entity;

public class Assistant {
	private Integer id;
	private String name;
	private String clas;
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	private int teachernum;
	private int grade;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getTeachernum() {
		return teachernum;
	}
	public void setTeachernum(int teachernum) {
		this.teachernum = teachernum;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
