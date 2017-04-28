package com.my.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.my.dao.CommandDao;
import com.my.entity.Command;
import com.my.entity.ICommand;
import com.my.entity.Message;
import com.my.util.MyBatisUtil;

@Component("commandDao")
public class CommandDaoImpl implements CommandDao{

	public List<Command> getCommandList(String name, String description) {
		// TODO Auto-generated method stub
		List<Command> commandlist = null;
		Command cmmd = new Command();
		cmmd.setName(name);
		cmmd.setDescription(description);
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			
			/*
			 * ����ָ�������ռ�Ϊ"com.my.entity.ICommand"ӳ���ļ���
			 * idΪ"getCommandList"��sql��䣬�������Ϊcmmd������ֵ����Ϊ
			 * List<Command>
			 */
			ICommand ic = sqlSession.getMapper(ICommand.class);
			commandlist = ic.getCommandList(cmmd);
			//�ύ����
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
		
		return commandlist;
	
	}

	public List<Command> getCommandListByPage(Map<String, Object> paramterMap) {
		// TODO Auto-generated method stub
		List<Command> commandlist = null;
		
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			
			ICommand ic = sqlSession.getMapper(ICommand.class);
			commandlist = ic.getCommandListByPage(paramterMap);
			//�ύ����
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
		
		return commandlist;
	
	}

	public int getCommandCounts() {
		// TODO Auto-generated method stub
		int counts = 0;
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			
			ICommand ic = sqlSession.getMapper(ICommand.class);
			counts = ic.getCommandCounts();
			//�ύ����
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
		
		return counts;
		
	}

	public boolean addOne(Command command) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			
			ICommand ic = sqlSession.getMapper(ICommand.class);
			command.setId(ic.getMaxId());
			ic.addOne(command);
			//�ύ����
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
		
		return true;
	}

	public boolean deleteOneById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			
			ICommand ic = sqlSession.getMapper(ICommand.class);
			ic.deleteOneById(id);

			//�ύ����
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
		
		return true;
		
	}

	public boolean deleteMany(List<Integer> idlist) {
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			
			ICommand ic = sqlSession.getMapper(ICommand.class);
			ic.deleteMany(idlist);

			//�ύ����
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
		
		return true;
		// TODO Auto-generated method stub
		
	}

}
