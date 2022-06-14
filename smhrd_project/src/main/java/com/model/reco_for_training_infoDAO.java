package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class reco_for_training_infoDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt = 0;
	
	public List<reco_for_training_infovo> reco_training_score_init(){
		session = sqlSessionFactory.openSession(true);
		List<reco_for_training_infovo> vo = null;
		try {
			vo = session.selectList("training_score_init");
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return vo;
		
	}
	
}
