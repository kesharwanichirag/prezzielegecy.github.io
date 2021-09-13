package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
import java.io.*;

import models.Admin;
import models.User;

public class AdminAllUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		ArrayList<User> users = User.getAllUsersForAdmin();
		request.setAttribute("all_users",users);	
	
		request.getRequestDispatcher("admin_all_user.jsp").forward(request,response);	
	}
}