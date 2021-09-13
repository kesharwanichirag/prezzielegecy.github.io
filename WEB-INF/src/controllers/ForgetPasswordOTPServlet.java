package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

import utils.OTP;
import utils.EmailSender;

public class ForgetPasswordOTPServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String email = request.getParameter("email"); 
		
		String otps = OTP.createOTP();
		String message = "Your one time password(OTP) from PREZZIE LEGECY in is "+otps;
		
		EmailSender.sendEmail(email,"welcome to prezzie legecy",message,"legecyprezzie@gmail.com","PrezzieLegecy@1");
			
		session.setAttribute("ftp_otp",otps);
	}
}