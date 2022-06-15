package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.reco_for_training_infovo;
import com.model.user_infoVO;
import com.model.user_training_infoDAO;
import com.model.user_training_infoVO;


@WebServlet("/surveyinsert")
public class surveyinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	HttpSession session = request.getSession();
	user_infoVO uservo =(user_infoVO)session.getAttribute("uvo");
	//user_training_infoVO q = (user_training_infoVO) request.getAttribute("q");
	
    //int training_index = q.getTraining_index();
	String user_id = uservo.getUser_id();
	
	int set_val1 = Integer.parseInt(request.getParameter("set_val1"));
	String secncnt_val1 = request.getParameter("secncnt_val1");
	
	int set_val2 = Integer.parseInt(request.getParameter("set_val2"));
	String secncnt_val2 = request.getParameter("secncnt_val2");
	
	int set_val3 = Integer.parseInt(request.getParameter("set_val3"));
	String secncnt_val3 = request.getParameter("secncnt_val3");
	
	user_training_infoVO vo1 = new user_training_infoVO();
	//vo1.setTraining_index(training_index);
	vo1.setUser_id(user_id);
	vo1.setSet_val(set_val1);
	vo1.setSecncnt_val(secncnt_val1);
	
	user_training_infoVO vo2 = new user_training_infoVO();
	//vo2.setTraining_index(training_index);
	vo2.setUser_id(user_id);
	vo2.setSet_val(set_val2);
	vo2.setSecncnt_val(secncnt_val2);
	
	user_training_infoVO vo3 = new user_training_infoVO();
	//vo3.setTraining_index(training_index);
	vo3.setUser_id(user_id);
	vo3.setSet_val(set_val3);
	vo3.setSecncnt_val(secncnt_val3);
		
	user_training_infoDAO dao = new user_training_infoDAO();
	
	int cnt1 = dao.surveyinsert(vo1);
	int cnt2 = dao.surveyinsert(vo2);
	int cnt3 = dao.surveyinsert(vo3);
	
	if(cnt3>0) {
		response.sendRedirect("detail.html");
	}else {
		System.out.println("½ÇÆÐ");
		response.sendRedirect("exercise.jsp");
	}
	
	
	}

}
