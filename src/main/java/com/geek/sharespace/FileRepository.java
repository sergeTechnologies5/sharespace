package com.geek.sharespace;

import java.util.ArrayList;

import com.geek.sharespace.models.Comment;
import com.geek.sharespace.models.File;
import com.geek.sharespace.models.User;

public class FileRepository implements IFileRepository {

	private ArrayList<File> _repository;
	
	public FileRepository()
	{
		_repository = new ArrayList<File>();
	}
	
	@Override
	public File[] get() {
		return _repository.toArray(new File[_repository.size()]);
	}

	@Override
	public File get(int id) {
		for(File file: _repository)
			if(file.getId() == id)
				return file;
		return null;
	}

	@Override
	public File get(String filename) {
		for(File file: _repository)
			if(file.getFilename() == filename)
				return file;
		return null;
	}

	@Override
	public File[] get(User user) {
		ArrayList<File> _list = new ArrayList<File>();
		int _user_id = user.getId();
		for(File file: _repository)
			if(file.getUser().getId() == _user_id)
				_list.add(file);
		return _list.toArray(new File[_list.size()]);
	}

	@Override
	public boolean Add(File file) {
		_repository.add(file);
		return true;
	}

}
