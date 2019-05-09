package com.geek.sharespace;

import com.geek.sharespace.models.User;

public interface IUserRepository {

	public User getUserByUsername(String username);
	public User getUserById(int id);
	public User[] getUsers();
	public boolean AddUser(User user);
}
