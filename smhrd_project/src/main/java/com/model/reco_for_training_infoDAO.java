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
	
	public List<String> reco_yesterday_training_parts(String user_id, String training_date){
		session = sqlSessionFactory.openSession(true);
		List<String> vo = null;
		reco_select_user_data user_data = new reco_select_user_data(user_id, training_date);
		System.out.println(user_data.getTraining_date());
		System.out.println(user_data.getUser_id());
		
		try {
			vo = session.selectList("reco_yesterday_training_parts",user_data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		
		return vo;
		
	}
	
}
