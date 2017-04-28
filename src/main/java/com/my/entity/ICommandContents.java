package com.my.entity;

import java.util.List;
/**
 * Mybatis接口式编程方式
 * 该接口与对象关系映射文件"CommandContents.xml"对应
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
