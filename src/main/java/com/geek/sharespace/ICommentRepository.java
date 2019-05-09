package com.geek.sharespace;

import com.geek.sharespace.models.Comment;
import com.geek.sharespace.models.File;
import com.geek.sharespace.models.User;

public interface ICommentRepository {

	public Comment getComment(int id);
	public Comment[] getComments();
	public Comment[] getComments(User user);
	public Comment[] getComments(File file);
	public boolean AddComment(Comment comment);
}
