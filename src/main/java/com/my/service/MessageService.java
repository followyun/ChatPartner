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
	 * ��ҳ��ʾ��ѯ�ļ�¼��
	 * @param currentPage ��ʾ�ڼ�ҳ
	 * @param pageNumber ÿҳ��ʾ�ļ�¼��
	 * @return
	 */
	public List<Command> getCommandListByPage(Page page);
	public boolean deleteCommands(String[] idarray);

	public String getMessagesByCommand(String command);
	
	/**
	 * ���һ����������Ҵ��ж�Ӧһ���ظ�����
	 * @param command ����
	 * @param commandContents �ظ�����
	 * @return �ɹ�����true ʧ�ܷ���false
	 */
	public boolean addNewCommandAndContent(Command command, 
			CommandContents commandContents);
}
