package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.user_training_infoDAO;
import com.model.user_training_infoVO;


@WebServlet("/surveyinsert")
public class surveyinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	int set_val = Integer.parseInt(request.getParameter("set_val"));
	String secncnt_val = request.getParameter("secncnt_val");
	String training_date = request.getParameter("training_date");
	
	user_training_infoVO vo = new user_training_infoVO();
	vo.setSet_val(set_val);
	vo.setSecncnt_val(secncnt_val);
	vo.setTraining_date(training_date);
	
	user_training_infoDAO dao = new user_training_infoDAO();
	
	int cnt = dao.surveyinsert(vo);
	
	if(cnt>0) {
		request.setAttribute("training_date", training_date);
		RequestDispatcher rd = request.getRequestDispatcher("exercise.jsp");
		rd.forward(request, response);
	}else {
		System.out.println("½ÇÆÐ");
		response.sendRedirect("new_user_survey.html");
	}
	
	
	}

}
