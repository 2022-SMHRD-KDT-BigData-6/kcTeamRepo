package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ex03SendAjax")
public class ex03SendAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ajax로 보내준 데이터를 가져오기
		String data = request.getParameter("data");
		String name = request.getParameter("name");

		System.out.println("내가 받아온 data는 " + data);
		System.out.println("내가 받아온 name은 " + name);
		
		// ajax를 활용해서 데이터를 돌려주려면 반드시 서버페이지에서
		// 돌려줄 데이터를 웹페이지로 출력해줘야한다.
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// 데이터를 돌려주기
		// json 구조로 돌려주는 방법
		// key : value 형태로 돌려줘야한다.
		// --> java에서 json구조를 만들어주는 외부 라이브러리를 사용해보자!
		// out.print("{\"name\":\"고진석\"}");
		
		// Gson 라이브러리 사용방법
		// java 객체 형태를 javascript의 json 구조로 변환
		
		// 1. 내가 전송해 줄 데이터를 java 객체 형태로 만들기
	}

}
