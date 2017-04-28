package com.my.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.my.dao.MessageDao;
import com.my.entity.Message;
import com.my.util.MyBatisUtil;

/**
 * @author yun
 *
 */
/**
 * @author yun
 *
 */
@Component("messageDao")
public class MessageDaoImpl implements MessageDao{

	public List<Message> getMessageList(String command, String description) {
		// TODO Auto-generated method stub
		List<Message> messagelist = new ArrayList<Message>();
		Message message = new Message();
		message.setCommand(command);
		message.setDescription(description);
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			/*
			 * Message.findOneMessage: 名为Message的映射关系文件中的id为findOneMessage的sql语句
			 */	
			messagelist = sqlSession.selectList("Message.getMessageList", message);
			//提交事务
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		
		return messagelist;
	}

	public boolean deleteOneMessageById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		int deletenums = 0;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			deletenums = sqlSession.delete("Message.deleteOneMessage", id);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		if(deletenums > 0)
			return true;
		else
			return false;
	}

	
	public int deleteMessages(List<Integer> idlist) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		int deletenums = 0;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			deletenums = sqlSession.delete("Message.deleteMessages", idlist);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return deletenums;
	}

	public int addNewMessage(Message message) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		int deletenums = 0;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			deletenums = sqlSession.insert("Message.addNewMessage", message);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return deletenums;
		
	}

}
