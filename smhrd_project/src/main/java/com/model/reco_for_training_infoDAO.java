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
   
   public List<String> reco_one_yesterday_training_parts(String user_id){
      session = sqlSessionFactory.openSession(true);
      List<String> vo = null;
      
      try {
         vo = session.selectList("reco_one_yesterday_training_parts",user_id);
      } catch (Exception e) {
         e.printStackTrace();
      }
      session.close();
      
      return vo;
      
   }
   
   
   public List<String> reco_two_yesterday_training_parts(String user_id){
      session = sqlSessionFactory.openSession(true);
      List<String> vo = null;
      
      try {
         vo = session.selectList("reco_two_yesterday_training_parts",user_id);
      } catch (Exception e) {
         e.printStackTrace();
      }
      session.close();
      
      return vo;
      
   }
   
   public List<today_user_trainingVO> reco_today_training_parts(String user_id){
      session = sqlSessionFactory.openSession(true);
      List<today_user_trainingVO> vo = null;
      
      try {
         vo = session.selectList("reco_today_training_parts",user_id);
      } catch (Exception e) {
         e.printStackTrace();
      }
      session.close();
      
      return vo;
      
   }
   
}