package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.reco_for_scoreTemp;
import com.model.reco_for_training_infoDAO;
import com.model.reco_for_training_infovo;
import com.model.reco_for_user_survay;
import com.model.reco_select_user_data;
import com.model.training_infoDAO;
import com.model.training_infoVO;

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
		reco_for_training_infoDAO dao = new reco_for_training_infoDAO();
	    List<reco_for_training_infovo> inVos = dao.reco_training_score_init();

	     System.out.println(inVos);
	    	
	     Calendar c1 = new GregorianCalendar();
	     c1.add(Calendar.DATE, -1); // ���ó�¥�κ��� -1
	     SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd"); // ��¥ ����
	     String d1 = sdf.format(c1.getTime())+"%"; // String���� ����
		 System.out.println(d1);
	     
	     
		 Calendar c2 = new GregorianCalendar();
		 c2.add(Calendar.DATE, -2); // ���ó�¥�κ��� -2
		 String d2 = sdf.format(c2.getTime())+"%"; // String���� ����
		 System.out.println(d2);
		 
	     
	      for (int i = 0; i < inVos.size(); i++)
	         score_lists.add(new reco_for_scoreTemp());

	      
	      reco_for_training_infoDAO yesterday_dao = new reco_for_training_infoDAO();

	      String b[] = { "Shoulders", "Back" };// ��ȣ����
	      String c[] = { "Barbell", "Dumbbells" };// �ⱸ
	      String a[] = { "Advanced", "Intermediate" };// ���̵�
	      List<String> list1 = yesterday_dao.reco_yesterday_training_parts("a", d1);
	      List<String> list2 = yesterday_dao.reco_yesterday_training_parts("a", d2);
	      String d[][] = { { "Back", "Legs","Arms" }, { "Hips", "Shoulders","Legs" } };
	      // ���̵�, ��ȣ����, ��ȣ, �ߴ� � ����, ��ȣ ���

	      reco_for_user_survay ui = new reco_for_user_survay(a, b, "����",d,c);
	      
	      System.out.println(list1);
	      System.out.println(list2);
	    
	      // ��ȣ�������
	      for (int i = 0; i < inVos.size(); i++) {

	         if (ui.getFavor_part()[0].equals(inVos.get(i).getTraining_part())) {
	            score_lists.get(i).setFavor_part_score(1);
	         }else if(ui.getFavor_part()[1].equals(inVos.get(i).getTraining_part())){
	            score_lists.get(i).setFavor_part_score(0.8);
	         }else {
	             score_lists.get(i).setFavor_part_score(0.1);
	          }
	      }
	      // ��ȣ����
	      for (int i = 0; i < inVos.size(); i++) {

	         if (ui.getHate_favor_part().equals(inVos.get(i).getTraining_part())) {
	            score_lists.get(i).setFavor_part_score(0);
	      }
	      }
	      

	      // �ⱸ���
	      for (int i = 0; i < inVos.size(); i++) {
	         
	         if (ui.getEq()[0].equals(inVos.get(i).getTraining_equip())) {
	            score_lists.get(i).setEq_score(0.6);
	         } else if (ui.getEq()[1].equals(inVos.get(i).getTraining_equip())) {
	            score_lists.get(i).setEq_score(0.4);
	         } else {
	            score_lists.get(i).setEq_score(0.2);
	         }
	      }
	      // ���̵� ���
	      for (int i = 0; i < inVos.size(); i++) {

	         if (ui.getLevel()[0].equals(inVos.get(i).getTraining_dif())) {
	            score_lists.get(i).setLevel_score(0.8);
	         } else if (ui.getLevel()[1].equals(inVos.get(i).getTraining_dif())) {
	            score_lists.get(i).setLevel_score(0.6);
	         } else {
	            score_lists.get(i).setLevel_score(0.2);
	         }
	      }
	      // �ߴ� ����
	      
	      for (int i = 0; i < inVos.size(); i++) {
	          
	          for(int j = 0; j<ui.getYesterday_part()[1].length; j++)
	               if(ui.getYesterday_part()[1][j].equals(inVos.get(i).getTraining_part())){
	                  score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-0.8);
	                  break;
	               }
	                  
	          
	          for(int j = 0; j<ui.getYesterday_part()[0].length; j++)
	             if(ui.getYesterday_part()[0][j].equals(inVos.get(i).getTraining_part())){
	                score_lists.get(i).setYesterday_part_score(score_lists.get(i).getYesterday_part_score()-1);
	                break;
	             }
	                
	          
	         
	       }

//	      // for ��
//	      System.out.println("��������ġ:");
//	      for (int i = 0; i < score_lists.size(); i++) {
//	         System.out.println(score_lists.get(i).getFavor_part_score());
//	      }
//	      System.out.println("�ⱸ����ġ:");
//	      for (int i = 0; i < score_lists.size(); i++) {
//	         System.out.println(score_lists.get(i).getEq_score());
//	      }
//	      System.out.println("���̵�����ġ:");
//	      for (int i = 0; i < score_lists.size(); i++) {
//	         System.out.println(score_lists.get(i).getLevel_score());
//	      }
//	      
//	      System.out.println("���� ��¥ � ���� ����ġ:");   
//	      for(int i =0; i<score_lists.size(); i++) {
//	         System.out.println(score_lists.get(i).getYesterday_part_score());
//	      }
//	      System.out.println("����ġ���ھ� ����");
//	      for(int i =0; i<score_lists.size(); i++) {
//	         inVos.get(i).setScore(score_lists.get(i).getLevel_score()*score_lists.get(i).getEq_score()*score_lists.get(i).getFavor_part_score()*score_lists.get(i).getYesterday_part_score());
//	          System.out.println(inVos.get(i).getScore());
//	       }
//	      for (int i = 0; i<inVos.size();i++) {   
//	         for (int j = 0; j < i; j++) {      
//	            if (inVos.get(j).getScore() > inVos.get(i).getScore() ) { 
//	               
//	               int temp = inVos.get(j).getTraining_index() ;             
//	               inVos.get(j).setTraining_index(inVos.get(i).getTraining_index());        
//	               inVos.get(i).setTraining_index(temp);  
//	               double temp_sc = inVos.get(j).getScore();             
//	               inVos.get(j).setScore(inVos.get(i).getScore());             
//	               inVos.get(i).setScore(temp_sc); 
//	               
//	            } 
//	         }
//	      }
//
//	      System.out.println("���� ��");
//	      for (int i = inVos.size(); i > inVos.size()-3; i--) {
//	         System.out.print(inVos.get(i-1).getTraining_index()+":"+inVos.get(i-1).getScore()+"\t");
//
//		
//	}

	}
}
