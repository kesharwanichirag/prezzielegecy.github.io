package controllers;

import javax.servlet.http.*;
import javax.servlet.*;
import java.util.*;
import java.io.*;

import models.Admin;

public class AdminLoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		request.getRequestDispatcher("admin_login.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String key = request.getParameter("key");
		String pin = request.getParameter("pin");

		Admin admin = new Admin(key,pin);
		String message = admin.loginAdmin();
		if(message.equals("done")){	
			response.sendRedirect("admin_page.do");
		}else{
			response.sendRedirect("admin_login.do");
		}
	}
}