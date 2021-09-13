package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
import java.io.*;

import models.*;

public class AdminUserViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		Integer userId = Integer.parseInt(request.getParameter("user_id"));
		User users = User.getUserDetilsForAdmin(userId);
		request.setAttribute("users",users);
		session.setMaxInactiveInterval(360000);
		session.setAttribute("users_temp",users);

		request.getRequestDispatcher("admin_user_view.jsp").forward(request,response);
		
	}
}