package com.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;


public class userDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	
	public userVO login(userVO uvo){
		SqlSession session = sqlSessionFactory.openSession(true);
		userVO result = null;
				try {
					result=session.selectOne("login",uvo);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				session.close();
		
		return result;
		
	}
	
}
