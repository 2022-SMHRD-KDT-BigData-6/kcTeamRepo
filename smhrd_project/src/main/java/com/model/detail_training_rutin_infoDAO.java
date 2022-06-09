package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class detail_training_rutin_infoDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt =0;	
	
	public int detail_rutininsert(detail_training_rutin_infoVO vo) {
		
		try {
			session = sqlSessionFactory.openSession(true);
			cnt = session.insert("detail_rutininsert",vo);
		} catch (Exception e) {
		e.printStackTrace();
		}
		session.close();
		return cnt;
	}


	public List<detail_training_rutin_infoVO> select_rutin(int rutin_index) {
		session = sqlSessionFactory.openSession(true);
		List<detail_training_rutin_infoVO> vo = null;
		try {
			vo = session.selectList("select_rutin",rutin_index);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return vo;
	}

	
	
	
}
