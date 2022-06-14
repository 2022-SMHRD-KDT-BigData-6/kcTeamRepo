package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

	String user_id = uservo.getUser_id();
	int set_val = Integer.parseInt(request.getParameter("set_val"));
	String secncnt_val = request.getParameter("secncnt_val");
	
	int training_index = (int) request.getAttribute("q");
	
	user_training_infoVO vo = new user_training_infoVO();
	vo.setUser_id(user_id);
	vo.setTraining_index(training_index);
	vo.setSet_val(set_val);
	vo.setSecncnt_val(secncnt_val);
		
	user_training_infoDAO dao = new user_training_infoDAO();
	
	int cnt = dao.surveyinsert(vo);
	
	if(cnt>0) {
		response.sendRedirect("detail_view.jsp");
	}else {
		System.out.println("½ÇÆÐ");
		response.sendRedirect("exercise.jsp");
	}
	
	
	}

}
