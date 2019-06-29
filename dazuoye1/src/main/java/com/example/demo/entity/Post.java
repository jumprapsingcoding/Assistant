package com.example.demo.entity;

public class Post {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getPostclass() {
		return postclass;
	}
	public void setPostclass(String postclass) {
		this.postclass = postclass;
	}
	
	private int postteacher;
	public int getPostteacher() {
		return postteacher;
	}
	public void setPostteacher(int postteacher) {
		this.postteacher = postteacher;
	}

	private String postclass;
}
