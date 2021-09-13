package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;

public class BlockUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		//Integer userId = Integer.parseInt(request.getParameter("user_id"));
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("users_temp");
		
		String message = User.blockUser(user.getUserId());

		if(message.equals("done")){
			request.setAttribute("done_msg",message);
			request.getRequestDispatcher("block_done.jsp").forward(request,response);
		}else{
			message = "not done";
			request.getRequestDispatcher("admin_login.jsp").forward(request,response);
		}
	}
}