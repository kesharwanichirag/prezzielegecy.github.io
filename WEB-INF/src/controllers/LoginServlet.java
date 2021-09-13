package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

import utils.ReCaptcha;

public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String nextPage = "login.jsp";

		String captchaResponse = request.getParameter("g-recaptcha-response");
		
		boolean flag = ReCaptcha.checkRecaptcha(captchaResponse);

		if(flag){
			String	UserNameEmail = request.getParameter("username_email");
			String password = request.getParameter("password");

			User user = new User();
			String message = user.userLogin(UserNameEmail,password);
			
			if(message.equals("Login Success...!")){
				session.setAttribute("user",user);
				response.sendRedirect("index.do");
			}else{
				request.setAttribute("error",message);
				request.getRequestDispatcher(nextPage).forward(request,response);
			}
		}else{
			request.setAttribute("error","captcha test failed..!");
			request.getRequestDispatcher(nextPage).forward(request,response);
		}
	}
}