package com.geek.sharespace.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class CommentViewModel {

	private int file;
	
	@NotNull
	private int user;
	
	@NotNull
	@Min(1)
	private String message;
	
	public int getFile() {
		return file;
	}
	
	public void setFile(int file) {
		this.file = file;
	}
	
	public int getUser() {
		return user;
	}
	
	public void setUser(int user) {
		this.user = user;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
