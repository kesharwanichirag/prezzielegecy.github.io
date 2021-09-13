package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

import utils.EmailSender;

public class ForgetPasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
		request.getRequestDispatcher("forgot_password.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		String otpClient = request.getParameter("otp");
		String otpSession = (String)session.getAttribute("ftp_otp");
		String message = "";
		boolean flag = true;
		String email = request.getParameter("email");
		if(otpClient.equals(otpSession)){
			String password = request.getParameter("password");
			String rePassword = request.getParameter("repassword");

			if(User.forgotPassword(email,password)){
				message += "your password has successfully changed";
				EmailSender.sendEmail(email,"welcome to prezzie legecy",message,"legecyprezzie@gmail.com","PrezzieLegecy@1");
				response.sendRedirect("login.do");
			}else{
				response.sendRedirect("forgot.do");
				message += "failed to change password";
				EmailSender.sendEmail(email,"welcome to prezzie legecy",message,"legecyprezzie@gmail.com","PrezzieLegecy@1");
			}
		}else{
			response.sendRedirect("login.do");		
			message += "otp was invalid";
			EmailSender.sendEmail(email,"welcome to prezzie legecy",message,"legecyprezzie@gmail.com","PrezzieLegecy@1");
		}
	}
}