package com.my.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.my.entity.Command;
import com.my.entity.CommandContents;
import com.my.entity.Message;
import com.my.entity.Page;


@Service
public interface MessageService {
	public List<Command> getCommandList(String command, String description);
	/**
	 * 分页显示查询的记录数
	 * @param currentPage 显示第几页
	 * @param pageNumber 每页显示的记录数
	 * @return
	 */
	public List<Command> getCommandListByPage(Page page);
	public boolean deleteCommands(String[] idarray);

	public String getMessagesByCommand(String command);
	
	/**
	 * 添加一条新命令，并且带有对应一条回复内容
	 * @param command 命令
	 * @param commandContents 回复内容
	 * @return 成功返回true 失败返回false
	 */
	public boolean addNewCommandAndContent(Command command, 
			CommandContents commandContents);
}
