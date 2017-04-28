package com.my.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.my.dao.CommandContentsDao;
import com.my.entity.CommandContents;
import com.my.service.CommandContentsService;
@Service("commandContentsService")
public class CommandContentsServiceImpl implements CommandContentsService {
	private CommandContentsDao commandContentsDao;
	@Autowired
	public void setCommandContentsDao(CommandContentsDao commandContentsDao) {
		this.commandContentsDao = commandContentsDao;
	}

	public void addOne(CommandContents commandContents) {
		// TODO Auto-generated method stub
		commandContentsDao.addOne(commandContents);
	}

	public void addMany(List<CommandContents> contentList) {
		// TODO Auto-generated method stub
		commandContentsDao.addMany(contentList);
	}

	public void deleteOne(int id) {
		// TODO Auto-generated method stub
		commandContentsDao.deleteOne(id);
	}

	public void deleteMany(List<Integer> ids) {
		// TODO Auto-generated method stub
		commandContentsDao.deleteMany(ids);
	}

	public List<CommandContents> queryCommandContentsById(int id) {
		// TODO Auto-generated method stub
		
		return commandContentsDao.queryCommandContentsById(id);
	}

	public boolean updateOne(CommandContents commandContents) {
		// TODO Auto-generated method stub
		return commandContentsDao.updateOne(commandContents);
	}

}
