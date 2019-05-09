package com.geek.sharespace;

import java.util.ArrayList;

import com.geek.sharespace.models.Comment;
import com.geek.sharespace.models.File;
import com.geek.sharespace.models.User;

public class CommentRepository implements ICommentRepository {
	
	static int last_id = 1;
	private ArrayList<Comment> comments;
	
	public CommentRepository()
	{
		comments = new ArrayList<Comment>();
	}
	
	@Override
	public Comment getComment(int id) {
		for(Comment comment: comments)
			if(comment.getId() == id)
				return comment;
		return null;
	}

	@Override
	public Comment[] getComments() {
		Comment[] _arr = new Comment[comments.size()];
		return comments.toArray(_arr);
	}

	@Override
	public Comment[] getComments(User user) {
		ArrayList<Comment> ret = new ArrayList<Comment>();
		int _user_id = user.getId();
		for(Comment comment: comments)
			if(comment.getUser().getId() == _user_id)
				ret.add(comment);
		return ret.toArray(new Comment[ret.size()]);
	}

	@Override
	public Comment[] getComments(File file) {
		ArrayList<Comment> ret = new ArrayList<Comment>();
		int _file_id = file.getId();
		for(Comment comment: comments)
			if(comment.getFile() != null && comment.getFile().getId() == _file_id)
				ret.add(comment);
		return ret.toArray(new Comment[ret.size()]);
	}

	@Override
	public boolean AddComment(Comment comment) {
		int _id = last_id++;
		comment.setId(_id);
		comments.add(comment);
		return true;
	}

}
