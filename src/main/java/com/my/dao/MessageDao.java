package com.my.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.my.entity.Message;
/**
 * �������ݿ�����Message�����Ӧ�ı��Dao�ӿ�
 * @author yun
 *
 */

@Component
public interface MessageDao {
	public List<Message> getMessageList(String command, String description);
	public boolean deleteOneMessageById(int id);

	/**
	 * 
	 * @param idlist: ����������id��list����
	 * @return �ɹ�ɾ���ļ�¼��
	 */
	public int deleteMessages(List<Integer> idlist);
	
	public int addNewMessage(Message message);
	
	
}
