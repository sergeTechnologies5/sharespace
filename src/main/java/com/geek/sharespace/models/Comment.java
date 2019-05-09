package com.geek.sharespace.models;

import java.util.Date;

public class Comment {
	
	private int id;
	private File file;
	private User user;
	private String message;
	private Date timestamp;
	
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Comment(User user, File file, String message)
	{
		this.user = user;
		this.file = file;
		this.message = message;
		timestamp = new Date();
	}
	
	public Comment(User user, String message)
	{
		this.user = user;
		this.message = message;
		timestamp = new Date();
	}
	
	public File getFile() {
		return file;
	}
	
	public String getMessage() {
		return message;
	}

	public User getUser() {
		return user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
