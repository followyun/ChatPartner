package com.my.util;

import java.io.IOException;
import java.io.InputStream;

import javax.security.auth.login.Configuration;
import javax.swing.plaf.synth.SynthSpinnerUI;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.springframework.core.ConfigurableObjectInputStream;

/**
 * Mybatis访问数据库基本配置
 * @author yun
 *
 */
public class MyBatisUtil {
	
	public  static SqlSession getSqlSession() throws IOException{
		String resource = "Configuration.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory sessionFactory = builder.build(in);
		SqlSession sqlSession = sessionFactory.openSession();

		return sqlSession;
	}
}
