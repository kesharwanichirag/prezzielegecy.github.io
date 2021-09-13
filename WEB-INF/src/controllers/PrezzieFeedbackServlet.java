package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

public class PrezzieFeedbackServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		if(user!=null){	
			request.getRequestDispatcher("prezzie_feedback_form.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		if(user!=null){	
			String userFeedback = request.getParameter("user_feedback");
			
			if(userFeedback.submitFeedbackToAdmin(user.getUserId(),userFeedback)){
				response.sendRedirect("index.do");
			}
			else{
				response.sendRedirect("prezzie_feedback.do");
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}