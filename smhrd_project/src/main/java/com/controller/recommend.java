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

			      inVos.add(new info_vo(1, "��", "�ٺ�", "��"));// ����,���,���̵�

			      for (int i = 0; i < inVos.size(); i++)
			         score_lists.add(new score_list());

			      String b[] = { "��ü", "����" };// ��ȣ����
			      String c[] = { "�ٺ�", "����" };// �ⱸ
			      String a[] = { "��", "��" };// ���̵�
			      String d[][] = { { "", "" }, { "", "" } };// �ߴ�����
			      // ���̵�, ��ȣ����, ��ȣ, �ߴ� � ����, ��ȣ ���
			      user_info ui = new user_info(a, b, "���", d, c);
			      
			      // ��ȣ����
			      for (int i = 0; i < inVos.size(); i++) {

			         if (ui.getHate_favor_part().equals(inVos.get(i).getPart())) {
			            score_lists.get(i).setFavor_part_score(0);
			         }else {
			             score_lists.get(i).setFavor_part_score(1);
			      }
			      }
			      
			      // ��ȣ�������
			      for (int i = 0; i < inVos.size(); i++) {

			         if (ui.getFavor_part()[0].equals(inVos.get(i).getPart())) {
			            score_lists.get(i).setFavor_part_score(1);
			         }else if(ui.getFavor_part()[1].equals(inVos.get(i).getPart())){
			            score_lists.get(i).setFavor_part_score(0.8);
			         }else {
			             score_lists.get(i).setFavor_part_score(0.1);
			          }
			      }
			     

			      // �ⱸ���
			      for (int i = 0; i < inVos.size(); i++) {
			         
			         if (ui.getEq()[0].equals(inVos.get(i).getEquip())) {
			            score_lists.get(i).setEq_score(0.6);
			         } else if (ui.getEq()[1].equals(inVos.get(i).getEquip())) {
			            score_lists.get(i).setEq_score(0.4);
			         } else {
			            score_lists.get(i).setEq_score(0.2);
			         }
			      }
			      // ���̵� ���
			      for (int i = 0; i < inVos.size(); i++) {

			         if (ui.getLevel()[0].equals(inVos.get(i).getDiff())) {
			            score_lists.get(i).setLevel_score(0.8);
			         } else if (ui.getLevel()[1].equals(inVos.get(i).getDiff())) {
			            score_lists.get(i).setLevel_score(0.6);
			         } else {
			            score_lists.get(i).setLevel_score(0.2);
			         }
			      }
			     
			    

			      // �ߴ� ����
			      
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
			      

			      
			      // for ��
			      System.out.println("��������ġ:");
			      for (int i = 0; i < score_lists.size(); i++) {
			         System.out.println(score_lists.get(i).getFavor_part_score());
			      }
			      System.out.println("�ⱸ����ġ:");
			      for (int i = 0; i < score_lists.size(); i++) {
			         System.out.println(score_lists.get(i).getEq_score());
			      }
			      System.out.println("���̵�����ġ:");
			      for (int i = 0; i < score_lists.size(); i++) {
			         System.out.println(score_lists.get(i).getLevel_score());
			      }
			      
			      System.out.println("���� ��¥ � ���� ����ġ:");   
			      for(int i =0; i<score_lists.size(); i++) {
			         System.out.println(score_lists.get(i).getYesterday_part_score());
			      }
			      System.out.println("����ġ���ھ� ����");
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

			      System.out.println("���� ��");
			      for (int i = inVos.size(); i > 0; i--) {
			         System.out.print(inVos.get(i-1).index+":"+inVos.get(i-1).score+"\t");
			      }
			      

			   }
	
	}

