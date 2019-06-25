package com.in28minutes.rest.webservices.post;

import java.util.Date;

public class Post {

	private Integer id;
	private Integer userId;
	private String message;
	private Date postedAt;

	public Post() {
	}
	
	
	
	public Post(Integer userId, String message) {
		super();
		this.userId = userId;
		this.message = message;
		this.postedAt = new Date();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getPostedAt() {
		return postedAt;
	}

	public void setPostedAt(Date postedAt) {
		this.postedAt = postedAt;
	}

}
