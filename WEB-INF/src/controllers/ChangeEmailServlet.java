package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

import utils.EmailSender;

public class ChangeEmailServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String message = "";
		boolean flag = true;
		String email = request.getParameter("email");
		if(user!=null){
			if(User.changeEmail(user.getUserId(),email)){
				user.setEmail(email);
				//message += "your email has successfully changed";
				//EmailSender.sendEmail(email,"welcome to prezzie legecy",message,"legecyprezzie@gmail.com","PrezzieLegecy@1");
				response.sendRedirect("settings.do");
			}else{
				response.sendRedirect("settings.do");
				//message += "failed to change email";
				//EmailSender.sendEmail(email,"welcome to prezzie legecy",message,"legecyprezzie@gmail.com","PrezzieLegecy@1");
			}
		}else{
			request.getRequestDispatcher("login.do").forward(request,response);
		}
	}
}