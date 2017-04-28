package com.my.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.my.entity.CommandContents;
@Component
public interface CommandContentsDao {
	/**
	 * 添加一条记录
	 * @param commandContents 命令内容的对象
	 * @return 成功返回true， 失败返回false
	 */
	public boolean addOne(CommandContents commandContents);
	/**
	 * 添加多条记录
	 * @param contentList 装有多条消息内容对象的list集合
	 * @return 成功返回true， 失败返回false
	 */
	public boolean addMany(List<CommandContents> contentList);
	/**
	 * 删除一条记录
	 * @param id 对应表中的id
	 * @return 成功返回true， 失败返回false
	 */
	public boolean deleteOne(int id);
	
	/**
	 * 删除多条记录
	 * @param ids 装有多个id的list集合
	 * @return 成功返回true， 失败返回false
	 */
	public boolean deleteMany(List<Integer> ids);
	
	public List<CommandContents> queryCommandContentsById(int id);
	
	public boolean updateOne(CommandContents commandContents);
}
