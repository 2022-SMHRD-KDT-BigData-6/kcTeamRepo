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

		// ajax�� ������ �����͸� ��������
		String data = request.getParameter("data");
		String name = request.getParameter("name");

		System.out.println("���� �޾ƿ� data�� " + data);
		System.out.println("���� �޾ƿ� name�� " + name);
		
		// ajax�� Ȱ���ؼ� �����͸� �����ַ��� �ݵ�� ��������������
		// ������ �����͸� ���������� ���������Ѵ�.
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset-UTF-8");
		
		PrintWriter out = response.getWriter();
		
		// �����͸� �����ֱ�
		// json ������ �����ִ� ���
		// key : value ���·� ��������Ѵ�.
		// --> java���� json������ ������ִ� �ܺ� ���̺귯���� ����غ���!
		// out.print("{\"name\":\"������\"}");
		
		// Gson ���̺귯�� �����
		// java ��ü ���¸� javascript�� json ������ ��ȯ
		
		// 1. ���� ������ �� �����͸� java ��ü ���·� �����
	}

}
