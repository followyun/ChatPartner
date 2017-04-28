package com.my.dao.impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.my.dao.CommandContentsDao;
import com.my.entity.CommandContents;
import com.my.entity.ICommandContents;
import com.my.util.MyBatisUtil;
@Component("commandContentsDao")
public class CommandContentsDaoImpl implements CommandContentsDao {

	public boolean addOne(CommandContents commandContents) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			ICommandContents iCommandContents = sqlSession.getMapper(ICommandContents.class);
			commandContents.setId(iCommandContents.getMaxId());
			iCommandContents.addOne(commandContents);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}

		return true;
	}

	public boolean addMany(List<CommandContents> contentList) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			ICommandContents iCommandContents = sqlSession.getMapper(ICommandContents.class);
			iCommandContents.addMany(contentList);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}

		return true;
	}

	public boolean deleteOne(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			ICommandContents iCommandContents = sqlSession.getMapper(ICommandContents.class);
			iCommandContents.deleteOne(id);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}

		return true;
	}

	public boolean deleteMany(List<Integer> ids) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			ICommandContents iCommandContents = sqlSession.getMapper(ICommandContents.class);
			iCommandContents.deleteMany(ids);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}

		return true;
	}

	public List<CommandContents> queryCommandContentsById(int id) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;
		List<CommandContents> contentlist = null;
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			ICommandContents iCommandContents = sqlSession.getMapper(ICommandContents.class);
			contentlist = iCommandContents.queryCommandContentsById(id);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}

		return contentlist;
	}

	public boolean updateOne(CommandContents commandContents) {
		// TODO Auto-generated method stub
		SqlSession sqlSession = null;	
		try {
			sqlSession = MyBatisUtil.getSqlSession();
			ICommandContents iCommandContents = sqlSession.getMapper(ICommandContents.class);
			iCommandContents.updateOne(commandContents);
			sqlSession.commit();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			if(sqlSession != null) {
				sqlSession.close();
			}
		}

		return true;
	}

}
