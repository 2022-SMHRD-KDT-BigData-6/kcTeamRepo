package com.model;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class training_rutin_infoDAO {
		SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
		SqlSession session = null;
		int cnt =0;	
		
	public int rutininsert(training_rutin_infoVO vo) {
		try {
			session = sqlSessionFactory.openSession(true);
			cnt = session.insert("rutininsert",vo);
		} catch (Exception e) {
		e.printStackTrace();
		}
		session.close();
		
		return cnt;
	}

	
}
