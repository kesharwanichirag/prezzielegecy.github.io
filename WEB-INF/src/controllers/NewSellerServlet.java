package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.File;

import models.User;
import models.Seller;

import utils.ReCaptcha;

public class NewSellerServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			request.getRequestDispatcher("new_seller.jsp").forward(request,response);	
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String captchaResponse = request.getParameter("g-recaptcha-response");
		boolean flag = ReCaptcha.checkRecaptcha(captchaResponse);

		if(flag){
			HttpSession session = request.getSession();
			User user = (User)session.getAttribute("user");
			if(user!=null){
				String sellerAccountName = request.getParameter("seller_account_name");
				String sellerBuisnessType = request.getParameter("seller_buisness_type");
				
				Seller seller = new Seller();
				if(Seller.createNewSeller(user,sellerAccountName,sellerBuisnessType)){
					String realPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName());
					
					File file = new File(realPath,sellerAccountName);
					
					file.mkdir();
					
					response.sendRedirect("seller.do");
				}else{
					request.getRequestDispatcher("new_seller.jsp").forward(request,response);
				}
			}else{
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}else{
			request.setAttribute("error","captcha test failed..!");
			request.getRequestDispatcher("new_seller.jsp").forward(request,response);
		}
	}	
}
