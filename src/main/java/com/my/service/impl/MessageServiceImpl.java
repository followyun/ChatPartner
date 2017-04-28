package com.my.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dao.CommandContentsDao;
import com.my.dao.CommandDao;
import com.my.entity.Command;
import com.my.entity.CommandContents;
import com.my.entity.Page;
import com.my.service.MessageService;
import com.my.util.CONSTANTS;



@Service("messageService")
public class MessageServiceImpl implements MessageService{
	private CommandDao commandDao;
	private CommandContentsDao commandContentsDao;
	private static Logger log = LoggerFactory.getLogger(MessageServiceImpl.class);

	@Autowired
	public void setCommandDao(CommandDao commandDao) {
		this.commandDao = commandDao;
	}
	
	@Autowired
	public void setCommandContentsDao(CommandContentsDao commandContentsDao) {
		this.commandContentsDao = commandContentsDao;
	}

	public boolean deleteCommands(String[] idarray) {
		// TODO Auto-generated method stub

		List<Integer> idlist = new ArrayList<Integer>();
		if(idarray.length > 0) {
			for (String str : idarray) {
				idlist.add(Integer.parseInt(str));
			}
		}
		commandDao.deleteMany(idlist);
		return true;
		
	}

		
	public String getMessagesByCommand(String command) {
		// TODO Auto-generated method stub
		StringBuilder reply = new StringBuilder();
		List<Command> commandlist = null;
		if(CONSTANTS.HELP_COMMAND.equals(command)) {
			commandlist = commandDao.getCommandList(null, null);
			
			for(int i = 0; i<commandlist.size(); i++) {
				if(i < commandlist.size() - 1) {
					reply.append("命令["+commandlist.get(i).getName()+"],描述["+
							commandlist.get(i).getDescription()+"]<br>");
				}else {
					reply.append("命令["+commandlist.get(i).getName()+"],描述["+
							commandlist.get(i).getDescription()+"]");
				}
			}
		}else {
			commandlist = commandDao.getCommandList(command, null);
			if(commandlist!=null && commandlist.size() > 0) {
				int index = new Random().nextInt(commandlist.get(0).getContentList().size());
				//从一个命令对应的多条回复内容中随机抽取一条
				String str = commandlist.get(0).getContentList().get(index).getContent();
				reply.append(str);			
			} else{
				reply.append(CONSTANTS.UNKNOW_COMMAND_CONTENT);
			}
		}
		return reply.toString();
	}
	public List<Command> getCommandList(String command, String description) {
		// TODO Auto-generated method stub

		return commandDao.getCommandList(command, description);
	}
	public List<Command> getCommandListByPage(Page page) {
		// TODO Auto-generated method stub
		int counts = commandDao.getCommandCounts();
		page.setTotalNumber(counts);
		page.count();
		Map<String, Object>paramtermap = new HashMap<String, Object>();
		paramtermap.put("dbIndex", page.getDbIndex());
		paramtermap.put("dbNumber", page.getDbNumber());
		
		return commandDao.getCommandListByPage(paramtermap);
	}
	public boolean addNewCommandAndContent(Command command, 
			CommandContents commandContents) {
		// TODO Auto-generated method stub
		commandDao.addOne(command);
		List<Command> commandlist = commandDao.getCommandList(command.getName(), command.getDescription());
		command = commandlist.get(0);
		commandContents.setCommandId(command.getId());
		commandContentsDao.addOne(commandContents);
		return true;
	}

}
