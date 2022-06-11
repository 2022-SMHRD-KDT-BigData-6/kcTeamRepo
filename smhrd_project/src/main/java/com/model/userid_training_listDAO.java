package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class userid_training_listDAO {

	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	int cnt = 0;
	
	public List<userid_training_listVO> select_training(String user_id){
		session = sqlSessionFactory.openSession(true);
		List<userid_training_listVO> vo = null;
		try {
			vo = session.selectList("select_training", user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return vo;
		
	}
}
