package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.detail_training_rutin_infoDAO;
import com.model.detail_training_rutin_infoVO;

@WebServlet("/select_rutin")
public class select_rutin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	int rutin_index = Integer.parseInt(request.getParameter("rutin_index"));
	
	detail_training_rutin_infoDAO dao = new detail_training_rutin_infoDAO();
	
	List<detail_training_rutin_infoVO> vo = dao.select_rutin(rutin_index);
	
	request.setAttribute("vo", vo);
	
	String nextPage = "test.jsp";
	RequestDispatcher rd = request.getRequestDispatcher(nextPage);
	rd.forward(request, response);
	
	}

}
