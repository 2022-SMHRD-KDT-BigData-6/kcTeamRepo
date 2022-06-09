package com.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;


public class user_infoDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt =0;
	
	public user_infoVO login(user_infoVO uvo){
		session = sqlSessionFactory.openSession(true);
		user_infoVO result = null;
				try {
					result=session.selectOne("login",uvo);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
				session.close();
		
		return result;
		
	}

	public int joininsert(user_infoVO uvo) {
		try {
			session = sqlSessionFactory.openSession(true);
			cnt = session.insert("joininsert",uvo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return cnt;
	}

	
	
}
