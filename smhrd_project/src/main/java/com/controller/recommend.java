package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/recommend")
public class recommend extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

			      List<score_list> score_lists = new ArrayList<score_list>();

			      List<info_vo> inVos = new ArrayList<info_vo>();

			      inVos.add(new info_vo(1, "등", "바벨", "상"));// 부위,장비,난이도

			      for (int i = 0; i < inVos.size(); i++)
			         score_lists.add(new score_list());

			      String b[] = { "하체", "전신" };// 선호부위
			      String c[] = { "바벨", "덤벨" };// 기구
			      String a[] = { "상", "중" };// 난이도
			      String d[][] = { { "", "" }, { "", "" } };// 했던부위
			      // 난이도, 선호부위, 비선호, 했던 운동 부위, 선호 장비
			      user_info ui = new user_info(a, b, "어깨", d, c);
			      
			      // 비선호부위
			      for (int i = 0; i < inVos.size(); i++) {

			         if (ui.getHate_favor_part().equals(inVos.get(i).getPart())) {
			            score_lists.get(i).setFavor_part_score(0);
			         }else {
			             score_lists.get(i).setFavor_part_score(1);
			      }
			      }
			      
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
			                 score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-0.2);
			                 break;
			              }
			                 
			         
			         for(int j = 0; j<ui.getYesterday_part()[0].length; j++)
			            if(ui.getYesterday_part()[0][j].equals(inVos.get(i).getPart())){
			               score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-0.5);
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
			         inVos.get(i).setScore((score_lists.get(i).getLevel_score()+score_lists.get(i).getEq_score()+score_lists.get(i).getFavor_part_score())*score_lists.get(i).getYesterday_part_score());
			          System.out.println(inVos.get(i).getScore());
			       }
			      for (int i = 0; i<inVos.size();i++) {   
			         for (int j = 0; j < i; j++) {      
			            if (inVos.get(j).getScore() > inVos.get(i).getScore() ) { 
			               
			               int temp = inVos.get(j).index ;             
			               inVos.get(j).index = inVos.get(i).index;             
			               inVos.get(i).index = temp;    
			               double temp_sc = inVos.get(j).score ;             
			               inVos.get(j).score = inVos.get(i).score;             
			               inVos.get(i).score = temp_sc; 
			            } 
			         }
			      }

			      System.out.println("정렬 후");
			      for (int i = inVos.size(); i > 0; i--) {
			         System.out.print(inVos.get(i-1).index+":"+inVos.get(i-1).score+"\t");
			      }
			      

			   }
	
	}

