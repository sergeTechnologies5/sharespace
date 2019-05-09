package com.geek.sharespace;

import java.util.ArrayList;

import com.geek.sharespace.models.User;

public class UserRepository implements IUserRepository{
	
	static int last_id = 1;
	private ArrayList<User> users;
	
	public UserRepository()
	{
		users = new ArrayList<User>();
	}
	
	public User getUserByUsername(String username)
	{
		for(User user : users)
		{
			if (user.getUsername().equals(username))
				return user;
		}
		return null;
	}

	@Override
	public User getUserById(int id) {
		for(User user : users)
		{
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public User[] getUsers() {
		User[] users = new User[this.users.size()];
		return this.users.toArray(users);
	}

	@Override
	public boolean AddUser(User user) {
		int _id = last_id++;
		user.setId(_id);
		users.add(user);
		return true;
		
	}
}
