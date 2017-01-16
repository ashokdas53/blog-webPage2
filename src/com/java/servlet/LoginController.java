package com.java.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.blog.ManageLogin;
import com.java.entity.Login;
/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String password=request.getParameter("password");
		
		System.out.println("username : "+userName);
		System.out.println("password : "+password);
		
		ManageLogin login = new ManageLogin();
		Login loginobj = login.manageLogin(userName, password);
		ManageLogin.getSession(loginobj);
		
		if(userName.equals("admin") && password.equals("admin"))
		{
			response.sendRedirect("/success.html");
			return ;
		}
		else
		{
			response.sendRedirect("/error.html");
			return;
		}
	}
}
