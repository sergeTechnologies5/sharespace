package com.geek.sharespace.models;

import java.io.IOException;
import java.util.Date;

import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.MultipartFile;

public class File {
	private int id;
	private long size;
	private String filename;
	private Date timestamp;
	private User user;
	private java.io.File file;
	private int downloads;

	private static int UUID = 1001;
	
	private File()
	{
		id = UUID++;
		timestamp = new Date(); 
	}
	
	public File(MultipartFile file, java.io.File directory, User user) throws IllegalStateException, IOException
	{
		this();
		filename = file.getOriginalFilename();
		size = file.getSize();
		if(directory == null)
		{
			directory = new java.io.File("fileStorage");
		}
		java.io.File mfile = new java.io.File(directory.getAbsolutePath() + java.io.File.separator + UUID);
		directory.mkdirs();
		mfile.createNewFile();
		file.transferTo(mfile);
		this.file = mfile;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}

	public long getSize() {
		return size;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}

	public User getUser() {
		return user;
	}
	
	public java.io.File getFile() {
		return file;
	}
	
	public int getDownloads() {
		return downloads;
	}
	
	public void increaseDownloadCount() {
		downloads++;
	}
}
