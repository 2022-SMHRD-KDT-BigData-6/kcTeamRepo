package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.user_training_infoDAO;
import com.model.user_training_infoVO;

@WebServlet("/select_index")
public class select_index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
//	String training_date = request.getParameter("training_date");
	
	user_training_infoDAO dao = new user_training_infoDAO();
	
	user_training_infoVO result = dao.select_index();

	
	System.out.println(result);
	
	String nextPage =null;
	if(result != null) {
		nextPage = "exercise.jsp";
	}else {
		nextPage = "new_user_survey.jsp";
	}
	
	RequestDispatcher rd = request.getRequestDispatcher(nextPage);
	rd.forward(request, response);
	
	}

}

//package com.controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.model.user_infoVO;
//import com.model.user_training_infoDAO;
//import com.model.user_training_infoVO;
//
//@WebServlet("/select_index")
//public class select_index extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	request.setCharacterEncoding("UTF-8");
//	
//	HttpSession session = request.getSession();
//	user_training_infoVO uservo =(user_training_infoVO)session.getAttribute("vo");
//	
//	user_training_infoDAO dao = new user_training_infoDAO();
//	
//	user_training_infoVO vo = dao.select_index();
//	
//	request.setAttribute("vo", vo);
//	
//	String nextPage =null;
//	if(vo!=null) {
//		nextPage = "exercise.jsp";
//	}else {
//		nextPage = "new_user_survey.jsp";
//	}
//	
//	RequestDispatcher rd = request.getRequestDispatcher(nextPage);
//	rd.forward(request, response);
//	
//	}
//
//}