package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;

public class UnBlockUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("users_temp");
		
		String message = User.unBlockUser(user.getUserId());

		if(message.equals("done")){
			request.getRequestDispatcher("unblock_done.jsp").forward(request,response);
		}else{
			message = "not done";
			request.getRequestDispatcher("admin_login.jsp").forward(request,response);
		}
	}
}