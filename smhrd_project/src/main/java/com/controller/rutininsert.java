package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.training_rutin_infoDAO;
import com.model.training_rutin_infoVO;


@WebServlet("/rutininsert")
public class rutininsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	String user_id = request.getParameter("user_id");
	String training_name = request.getParameter("training_name");
	String myobject = request.getParameter("myobject");
	String start_date = request.getParameter("start_date");
	String end_date = request.getParameter("end_date");
	
	training_rutin_infoVO vo = new training_rutin_infoVO();
	vo.setUser_id(user_id);
	vo.setTraining_name(training_name);
	vo.setMyobject(myobject);
	vo.setStart_date(start_date);
	vo.setEnd_date(end_date);
	
	training_rutin_infoDAO dao = new training_rutin_infoDAO();
	
	int cnt = dao.rutininsert(vo);
	
	if(cnt>0) {
		request.setAttribute("training_name", training_name);
		RequestDispatcher rd = request.getRequestDispatcher("Main.jsp");
		rd.forward(request, response);
		System.out.println("루틴추가 성공");
	}else {
		System.out.println("루틴추가 실패");
		response.sendRedirect("Main.jsp");
	}
	
	
	}

}
