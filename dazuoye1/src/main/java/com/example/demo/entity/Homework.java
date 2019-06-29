package com.example.demo.entity;

public class Homework {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private int opnum;
	private int stunum;
	private String clas;
	private int grade;
	
	public int getOpnum() {
		return opnum;
	}
	public void setOpnum(int opnum) {
		this.opnum = opnum;
	}
	public int getStunum() {
		return stunum;
	}
	public void setStunum(int stunum) {
		this.stunum = stunum;
	}
	public String getClas() {
		return clas;
	}
	public void setClas(String clas) {
		this.clas = clas;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}
