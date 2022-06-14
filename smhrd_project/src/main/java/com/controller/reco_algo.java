package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.reco_for_scoreTemp;
import com.model.reco_for_training_infovo;
import com.model.reco_for_user_survay;

/**
 * Servlet implementation class reco_algo
 */
@WebServlet("/reco_algo")
public class reco_algo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		/*알고리즘 시작*/
		List<reco_for_scoreTemp> score_lists = new ArrayList<reco_for_scoreTemp>();
		
	      List<reco_for_training_infovo> inVos = new ArrayList<reco_for_training_infovo>();

	      inVos.add(new reco_for_training_infovo(1, "등", "바벨", "상"));// 부위,장비,난이도
	      inVos.add(new reco_for_training_infovo(2, "팔", "덤벨", "상"));
	      inVos.add(new reco_for_training_infovo(3, "하체", "머신", "중"));
	      inVos.add(new reco_for_training_infovo(4, "어깨", "바벨", "하"));
	      inVos.add(new reco_for_training_infovo(5, "전신", "덤벨", "하"));
	      inVos.add(new reco_for_training_infovo(6, "가슴", "바벨", "중"));
	      inVos.add(new reco_for_training_infovo(7, "엉덩이", "바벨", "상"));
	      inVos.add(new reco_for_training_infovo(8, "등", "덤벨", "상"));
	      inVos.add(new reco_for_training_infovo(9, "팔", "머신", "상"));
	      inVos.add(new reco_for_training_infovo(10, "하체", "바벨", "중"));
	      inVos.add(new reco_for_training_infovo(11, "어깨", "덤벨", "하"));
	      inVos.add(new reco_for_training_infovo(12, "전신", "덤벨", "중"));
	      inVos.add(new reco_for_training_infovo(13, "가슴", "머신", "하"));
	      inVos.add(new reco_for_training_infovo(14, "엉덩이", "바벨", "중"));

	      for (int i = 0; i < inVos.size(); i++)
	         score_lists.add(new reco_for_scoreTemp());

	      String b[] = { "어깨", "등" };// 선호부위
	      String c[] = { "바벨", "덤벨" };// 기구
	      String a[] = { "상", "중" };// 난이도
	      String d[][] = { { "등", "전신" }, { "엉덩이", "하체" } };// 했던부위
	      // 난이도, 선호부위, 비선호, 했던 운동 부위, 선호 장비
	      reco_for_user_survay ui = new reco_for_user_survay(a, b, "가슴", d, c);
	      
	    
	      // 선호부위계산
	      for (int i = 0; i < inVos.size(); i++) {

	         if (ui.getFavor_part()[0].equals(inVos.get(i).getPart())) {
	            score_lists.get(i).setFavor_part_score(1);
	         }else if(ui.getFavor_part()[1].equals(inVos.get(i).getPart())){
	            score_lists.get(i).setFavor_part_score(0.8);
	         }else {
	             score_lists.get(i).setFavor_part_score(0.1);
	          }
	      }
	      // 비선호부위
	      for (int i = 0; i < inVos.size(); i++) {

	         if (ui.getHate_favor_part().equals(inVos.get(i).getPart())) {
	            score_lists.get(i).setFavor_part_score(0);
	      }
	      }
	      

	      // 기구계산
	      for (int i = 0; i < inVos.size(); i++) {
	         
	         if (ui.getEq()[0].equals(inVos.get(i).getEquip())) {
	            score_lists.get(i).setEq_score(0.6);
	         } else if (ui.getEq()[1].equals(inVos.get(i).getEquip())) {
	            score_lists.get(i).setEq_score(0.4);
	         } else {
	            score_lists.get(i).setEq_score(0.2);
	         }
	      }
	      // 난이도 계산
	      for (int i = 0; i < inVos.size(); i++) {

	         if (ui.getLevel()[0].equals(inVos.get(i).getDiff())) {
	            score_lists.get(i).setLevel_score(0.8);
	         } else if (ui.getLevel()[1].equals(inVos.get(i).getDiff())) {
	            score_lists.get(i).setLevel_score(0.6);
	         } else {
	            score_lists.get(i).setLevel_score(0.2);
	         }
	      }
	      // 했던 부위
	      
	      for (int i = 0; i < inVos.size(); i++) {
	         
	         for(int j = 0; j<ui.getYesterday_part()[1].length; j++)
	              if(ui.getYesterday_part()[1][j].equals(inVos.get(i).getPart())){
	                 score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-0.8);
	                 break;
	              }
	                 
	         
	         for(int j = 0; j<ui.getYesterday_part()[0].length; j++)
	            if(ui.getYesterday_part()[0][j].equals(inVos.get(i).getPart())){
	               score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-1);
	               break;
	            }
	               
	         
	        
	      }
	      // for 끝
	      System.out.println("부위가중치:");
	      for (int i = 0; i < score_lists.size(); i++) {
	         System.out.println(score_lists.get(i).getFavor_part_score());
	      }
	      System.out.println("기구가중치:");
	      for (int i = 0; i < score_lists.size(); i++) {
	         System.out.println(score_lists.get(i).getEq_score());
	      }
	      System.out.println("난이도가중치:");
	      for (int i = 0; i < score_lists.size(); i++) {
	         System.out.println(score_lists.get(i).getLevel_score());
	      }
	      
	      System.out.println("이전 날짜 운동 관련 가중치:");   
	      for(int i =0; i<score_lists.size(); i++) {
	         System.out.println(score_lists.get(i).getYesterday_part_score());
	      }
	      System.out.println("가중치스코어 총합");
	      for(int i =0; i<score_lists.size(); i++) {
	         inVos.get(i).setScore(score_lists.get(i).getLevel_score()*score_lists.get(i).getEq_score()*score_lists.get(i).getFavor_part_score()*score_lists.get(i).getYesterday_part_score());
	          System.out.println(inVos.get(i).getScore());
	       }
	      for (int i = 0; i<inVos.size();i++) {   
	         for (int j = 0; j < i; j++) {      
	            if (inVos.get(j).getScore() > inVos.get(i).getScore() ) { 
	               
	               int temp = inVos.get(j).getIndex() ;             
	               inVos.get(j).setIndex(inVos.get(i).getIndex());             
	               inVos.get(i).setIndex(temp);   
	               double temp_sc = inVos.get(j).getScore();             
	               inVos.get(j).setScore(inVos.get(i).getScore());             
	               inVos.get(i).setScore(temp_sc); 
	               
	            } 
	         }
	      }

	      System.out.println("정렬 후");
	      for (int i = inVos.size(); i > inVos.size()-3; i--) {
	         System.out.print(inVos.get(i-1).getIndex()+":"+inVos.get(i-1).getScore()+"\t");

		
	}

	}
}
