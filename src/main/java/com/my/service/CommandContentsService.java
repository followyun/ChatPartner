package com.my.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.my.entity.CommandContents;
@Service
public interface CommandContentsService {
	public void addOne(CommandContents commandContents);

	public void addMany(List<CommandContents> contentList);

	public void deleteOne(int id);
	
	public void deleteMany(List<Integer> ids);
	
	public List<CommandContents> queryCommandContentsById(int id);
	
	public boolean updateOne(CommandContents commandContents);
}
