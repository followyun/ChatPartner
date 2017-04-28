package com.my.entity;

import java.util.List;
import java.util.Map;

/**
 * Mybatis�ӿ�ʽ��̷�ʽ
 * �ýӿ�������ϵӳ���ļ�"Command.xml"��Ӧ
 * @author yun
 *
 */
public interface ICommand {
	
	/**
	 * �÷�����Ӧ"Command.xml"�ļ��е�һ��sql���
	 * ������geCommandList��Ӧ�ļ���sql����id
	 * 
	 * @param command��Ӧִ��sql��䴫��Ĳ���
	 * @return ��Ӧsql���ִ�к󷵻صĽ��
	 */
	public List<Command> getCommandList(Command command);
	
	public List<Command> getCommandListByPage(Map<String, Object> paramterMap);
	
	public int getCommandCounts();
	
	public void addOne(Command command);
	
	public void deleteOneById(int id);
	
	public void deleteMany(List<Integer> idlist);
	public int getMaxId();
}
