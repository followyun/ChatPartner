package com.my.entity;

import java.util.List;
import java.util.Map;

/**
 * Mybatis接口式编程方式
 * 该接口与对象关系映射文件"Command.xml"对应
 * @author yun
 *
 */
public interface ICommand {
	
	/**
	 * 该方法对应"Command.xml"文件中的一条sql语句
	 * 方法名geCommandList对应文件中sql语句的id
	 * 
	 * @param command对应执行sql语句传入的参数
	 * @return 对应sql语句执行后返回的结果
	 */
	public List<Command> getCommandList(Command command);
	
	public List<Command> getCommandListByPage(Map<String, Object> paramterMap);
	
	public int getCommandCounts();
	
	public void addOne(Command command);
	
	public void deleteOneById(int id);
	
	public void deleteMany(List<Integer> idlist);
	public int getMaxId();
}
