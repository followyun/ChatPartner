package com.my.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.my.entity.Message;
/**
 * 访问数据库中与Message对象对应的表的Dao接口
 * @author yun
 *
 */

@Component
public interface MessageDao {
	public List<Message> getMessageList(String command, String description);
	public boolean deleteOneMessageById(int id);

	/**
	 * 
	 * @param idlist: 保存多个整型id的list集合
	 * @return 成功删除的记录数
	 */
	public int deleteMessages(List<Integer> idlist);
	
	public int addNewMessage(Message message);
	
	
}
