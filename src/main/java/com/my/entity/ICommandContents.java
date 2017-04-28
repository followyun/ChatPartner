package com.my.entity;

import java.util.List;
/**
 * Mybatis�ӿ�ʽ��̷�ʽ
 * �ýӿ�������ϵӳ���ļ�"CommandContents.xml"��Ӧ
 * @author yun
 *
 */
public interface ICommandContents {

	public void addOne(CommandContents commandContents);

	public void addMany(List<CommandContents> contentList);

	public void deleteOne(int id);
	
	public void deleteMany(List<Integer> ids);
	
	public int getMaxId();
	
	public List<CommandContents> queryCommandContentsById(int id);
	
	public void updateOne(CommandContents commandContents);
}
