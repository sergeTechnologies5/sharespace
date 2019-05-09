package com.geek.sharespace.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SignupViewModel {

    @NotNull
    @Size(min=2, max=32)
	private String username;
    
    @NotNull
    @Size(min=8, max=32)
	private String password;

    @NotNull
    @Size(min=8, max=32)
    private String email;
    
    @NotNull
    @Size(min=2, max=32)
    private String firstname;
    
    @NotNull
    @Size(min=2, max=32)
    private String lastname;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
