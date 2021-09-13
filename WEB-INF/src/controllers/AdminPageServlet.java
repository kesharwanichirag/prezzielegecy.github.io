package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
import java.io.*;

import models.*;

public class AdminPageServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		ArrayList<User> users = User.getAllUsersForAdmin();
		request.setAttribute("all_users_count",users);

		request.getRequestDispatcher("admin_page.jsp").forward(request,response);
		
	}
}