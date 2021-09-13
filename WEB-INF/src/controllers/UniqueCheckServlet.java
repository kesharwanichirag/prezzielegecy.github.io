package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

public class UniqueCheckServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		String uniqueKey = request.getParameter("ukey");
			
		boolean flag = User.uniqueKey(uniqueKey);
			
		response.getWriter().write(flag+"");
	
	}
}