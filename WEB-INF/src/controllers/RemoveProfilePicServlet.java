package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.util.*;

import models.*;

public class RemoveProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			if(User.removeProfilePic(user.getUserId())){

				user.setProfPic("user/user.png");			
				
				request.getRequestDispatcher("profile_pic.jsp").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}