package com.geek.sharespace;

import com.geek.sharespace.models.File;
import com.geek.sharespace.models.User;

public interface IFileRepository {

	public File[] get();
	public File get(int id);
	public File get(String filename);
	public File[] get(User user);
	public boolean Add(File file);
}
