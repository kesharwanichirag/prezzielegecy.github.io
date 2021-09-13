package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

public class ChangePasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String message = "";
		boolean flag = true;
		if(user!=null){
			String newPsw = request.getParameter("new_psw");
			String reNewPsw = request.getParameter("re_new_psw");
			int passwordLength = newPsw.length();
			
			if(passwordLength<6||passwordLength>12){
				flag = false;
				message += "password must be atleast 6 digit..!";
				request.setAttribute("error",message);
				request.getRequestDispatcher("change_psw2.jsp").forward(request,response);
			}
			if(!newPsw.equals(reNewPsw)){
				flag = false;
				message += "password and repassword must match..!";
				request.setAttribute("error",message);
				request.getRequestDispatcher("change_psw2.jsp").forward(request,response);
			}

			if(User.changePassword(user.getUserId(),newPsw)){	
				response.sendRedirect("ac_settings.do");
			}else{
				response.sendRedirect("change_psw.do");
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}

