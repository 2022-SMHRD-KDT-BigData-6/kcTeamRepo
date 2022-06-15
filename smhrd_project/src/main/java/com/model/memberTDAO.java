package com.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.database.SqlSessionManager;

public class memberTDAO {
	SqlSessionFactory sqlSessionFactory = SqlSessionManager.getSqlSessionFactory();
	SqlSession session = null;
	
	public List<String> user_info_img(){
		SqlSession session = sqlSessionFactory.openSession(true);
		List<String> list= session.selectList("usertselect");
		
		session.close();
		 
		return list;
	} 
	
	
	
	public List<usertlVO> user_info_all(String user_id, String date){
		SqlSession session = sqlSessionFactory.openSession(true);
		usertlVO utlvo = new usertlVO();
		utlvo.setUser_id(user_id);
		utlvo.setTraining_date(date);
		
		List<usertlVO> list= session.selectList("usertselect_all",utlvo);
		
		session.close();
		
		for(usertlVO i : list) {
			
			
		}
		
		return list;
	} 
	
	
}
