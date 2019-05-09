package com.geek.sharespace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.geek.sharespace.models.User;

@SpringBootApplication
public class SharespaceApplication {

	private static IUserRepository userrepository = new UserRepository();
	private static IFileRepository filerepository = new FileRepository();
	private static ICommentRepository commentrepository = new CommentRepository();
	
	{
		userrepository.AddUser(new User("admin", "pass", "admin@sharespace.com", "System", "Administrator"));
	}
	
	public static void main(String[] args) {

 	 			SpringApplication.run(SharespaceApplication.class, args);

	}

	public static IUserRepository getUserRepository()
	{
		return userrepository;
	}

	public static ICommentRepository getCommentRepository()
	{
		return commentrepository;
	}

	public static IFileRepository getFileRepository()
	{
		return filerepository;
	}
}

