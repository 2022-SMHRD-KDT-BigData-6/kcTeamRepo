package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex01Ajax")
public class ex01Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("들어오니?");

		// 웹페이지에 출력해줘야 ajax로 데이터를 보내줄 수 있다.

		// 1. 인코딩
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		// 2. PrintWriter객체
		PrintWriter out = response.getWriter();
		// 3. 웹페이지에 출력
		
		out.print("");
	}

}
