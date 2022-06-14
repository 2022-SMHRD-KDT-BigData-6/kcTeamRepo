package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class user_training_infoDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt =0;	
	
	public int surveyinsert(user_training_infoVO vo) {
		
		try {
			session = sqlSessionFactory.openSession(true);
			cnt = session.insert("surveyinsert",vo);
		} catch (Exception e) {
		e.printStackTrace();
		}
		session.close();
		return cnt;
	}


<<<<<<< HEAD
	public int select_index() {
=======
	public user_training_infoVO select_index() {
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-BigData-6/kcTeamRepo.git
		session = sqlSessionFactory.openSession(true);
		int vo = 0;
		try {
			vo = session.selectOne("select_index");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return vo;
	}

	
	
	
}
