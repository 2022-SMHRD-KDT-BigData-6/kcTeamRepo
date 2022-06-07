package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.userDAO;
import com.model.userVO;

/**
 * Servlet implementation class LoginService
 */
@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	
	String user_id = request.getParameter("user_id");
	String user_pw = request.getParameter("user_pw");
	
	userVO uvo = new userVO();
	uvo.setUser_id(user_id);
	uvo.setUser_pw(user_id);
	
	userDAO dao = new userDAO();
	userVO result = dao.login(uvo);
	
	if(result != null) {
		System.out.println("로그인 성공");
		
		HttpSession session = request.getSession();
		session.setAttribute("uvo", result);
	}else {
		System.out.println("로그인 실패");
	}
	
	//response.sendRedirect("GoMain"); 만들면 이동
	
	}

}
