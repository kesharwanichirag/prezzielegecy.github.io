package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

public class CheckPasswordForEmailServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			request.getRequestDispatcher("check_password_email.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			String oldPsw = request.getParameter("password");	
			
			String message = User.checkPassword(oldPsw,user.getUserId());

			if(message.equals("success..")){
				response.sendRedirect("change_email.jsp");
			}else{
				request.setAttribute("psw_",message);
				request.getRequestDispatcher("check_password_email.jsp").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}

