package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

import utils.EmailSender;

public class ChangeUsernameServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		request.getRequestDispatcher("change_username.jsp").forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String message = "";
		boolean flag = true;
		String userName = request.getParameter("username");
		if(user!=null){
			if(User.changeUserName(user.getUserId(),userName)){
				user.setUserName(userName);
				response.sendRedirect("settings.do");
			}else{
				response.sendRedirect("settings.do");
			}
		}else{
			request.getRequestDispatcher("login.do").forward(request,response);
		}
	}
}