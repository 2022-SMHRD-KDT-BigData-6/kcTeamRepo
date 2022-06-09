package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.detail_training_rutin_infoDAO;
import com.model.detail_training_rutin_infoVO;

@WebServlet("/detail_rutininsert")
public class detail_rutininsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	int rutin_index = Integer.parseInt(request.getParameter("rutin_index"));
	int training_index = Integer.parseInt(request.getParameter("training_index"));
	int set_val = Integer.parseInt(request.getParameter("set_val"));
	String secncnt_val = request.getParameter("secncnt_val");
	int favor_check = Integer.parseInt(request.getParameter("favor_check"));
	
	detail_training_rutin_infoVO vo = new detail_training_rutin_infoVO();
	vo.setRutin_index(rutin_index);
	vo.setTraining_index(training_index);
	vo.setSet_val(set_val);
	vo.setSecncnt_val(secncnt_val);
	vo.setFavor_check(favor_check);
	
	detail_training_rutin_infoDAO dao = new detail_training_rutin_infoDAO();
	int cnt = dao.detail_rutininsert(vo);
	
	if(cnt>0) {
		request.setAttribute("favor_check", favor_check);
		RequestDispatcher rd = request.getRequestDispatcher("Main.jsp");
		rd.forward(request, response);
		System.out.println("운동 루틴에 추가 성공");
	}else {
		System.out.println("운동 추가 실패");
		response.sendRedirect("Main.jsp");
	}
	
	
	
	}

}
