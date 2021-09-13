package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;

import models.User;

import utils.ReCaptcha;
import utils.EmailSender;
import utils.ActivationCode;
import utils.EmailMessages;


public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		request.getRequestDispatcher("register.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{		
		String captchaResponse = request.getParameter("g-recaptcha-response");
		
		boolean flag = true;

		String errorMessage = ""; 
		
		flag = ReCaptcha.checkRecaptcha(captchaResponse);
			
		if(flag){
			String userName = request.getParameter("username");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("repassword");
			//String mobile = request.getParameter("mobile");
			
			
			Pattern pattern = null;
			Matcher matcher = null;

			pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{5,19}$");

			matcher = pattern.matcher(userName);

			if(!matcher.matches()){
				flag = false;

				errorMessage += "user name must contain alphabetic symbol and numeric symbol";
			}
			
		
			pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

			matcher = pattern.matcher(email);

			if(!matcher.matches()){
				flag = false;

				errorMessage += "invalid email entered";
			}
		
			int passwordLength = password.length();

			if(passwordLength<6||passwordLength>12){
				flag = false;
				errorMessage += "password must be atleast 6 digit";
			}

			if(!password.equals(rePassword)){
				flag = false;
				
				errorMessage += "password and repassword must match";
			}

			if(flag){
				String activationCode = ActivationCode.getActivationCode();
				
				if(User.saveUser(userName,email,password,activationCode)){
					String message = EmailMessages.getMail(userName,activationCode);
						
					EmailSender.sendEmail(email,"welcome to prezzie legecy",message,"legecyprezzie@gmail.com","PrezzieLegecy@1");
					
					String realPath = getServletContext().getRealPath("/WEB-INF/uploads");
					File file = new File(realPath,userName);
					file.mkdir();

					response.sendRedirect("login.do");
				}else{
					flag = false;
					errorMessage += "username and email already exist please login";
				}
			}
		}else{
			errorMessage += "captcha test failed";
		}
		if(!flag){
			request.setAttribute("error",errorMessage);
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}
	}
}