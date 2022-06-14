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
		
		
		/*�˰��� ����*/
		List<reco_for_scoreTemp> score_lists = new ArrayList<reco_for_scoreTemp>();
		
	      List<reco_for_training_infovo> inVos = new ArrayList<reco_for_training_infovo>();

	      inVos.add(new reco_for_training_infovo(1, "��", "�ٺ�", "��"));// ����,���,���̵�
	      inVos.add(new reco_for_training_infovo(2, "��", "����", "��"));
	      inVos.add(new reco_for_training_infovo(3, "��ü", "�ӽ�", "��"));
	      inVos.add(new reco_for_training_infovo(4, "���", "�ٺ�", "��"));
	      inVos.add(new reco_for_training_infovo(5, "����", "����", "��"));
	      inVos.add(new reco_for_training_infovo(6, "����", "�ٺ�", "��"));
	      inVos.add(new reco_for_training_infovo(7, "������", "�ٺ�", "��"));
	      inVos.add(new reco_for_training_infovo(8, "��", "����", "��"));
	      inVos.add(new reco_for_training_infovo(9, "��", "�ӽ�", "��"));
	      inVos.add(new reco_for_training_infovo(10, "��ü", "�ٺ�", "��"));
	      inVos.add(new reco_for_training_infovo(11, "���", "����", "��"));
	      inVos.add(new reco_for_training_infovo(12, "����", "����", "��"));
	      inVos.add(new reco_for_training_infovo(13, "����", "�ӽ�", "��"));
	      inVos.add(new reco_for_training_infovo(14, "������", "�ٺ�", "��"));

	      for (int i = 0; i < inVos.size(); i++)
	         score_lists.add(new reco_for_scoreTemp());

	      String b[] = { "���", "��" };// ��ȣ����
	      String c[] = { "�ٺ�", "����" };// �ⱸ
	      String a[] = { "��", "��" };// ���̵�
	      String d[][] = { { "��", "����" }, { "������", "��ü" } };// �ߴ�����
	      // ���̵�, ��ȣ����, ��ȣ, �ߴ� � ����, ��ȣ ���
	      reco_for_user_survay ui = new reco_for_user_survay(a, b, "����", d, c);
	      
	    
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
	      // ��ȣ����
	      for (int i = 0; i < inVos.size(); i++) {

	         if (ui.getHate_favor_part().equals(inVos.get(i).getPart())) {
	            score_lists.get(i).setFavor_part_score(0);
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
	                 score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-0.8);
	                 break;
	              }
	                 
	         
	         for(int j = 0; j<ui.getYesterday_part()[0].length; j++)
	            if(ui.getYesterday_part()[0][j].equals(inVos.get(i).getPart())){
	               score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-1);
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

	      System.out.println("���� ��");
	      for (int i = inVos.size(); i > inVos.size()-3; i--) {
	         System.out.print(inVos.get(i-1).getIndex()+":"+inVos.get(i-1).getScore()+"\t");

		
	}

	}
}
