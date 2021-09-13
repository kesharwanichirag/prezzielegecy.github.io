package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

import utils.OTP;
import utils.SMS;

public class OTPServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			String mobile = request.getParameter("mobile"); 
				
			String otp = OTP.createOTP();

			String message = "Your one time password(OTP) from PREZZIE LEGECY in "+mobile+ "is "+otp;
			
			//SMS.sendSms(mobile,message);
		
			session.setAttribute("otp",otp);
		}else{
			response.sendRedirect("login.do");
		}
	}
}