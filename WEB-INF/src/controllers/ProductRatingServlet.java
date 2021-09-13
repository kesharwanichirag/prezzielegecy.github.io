package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.google.gson.Gson;

import models.User;
import models.Product;
import models.ProductReview;

public class ProductRatingServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null){
			Integer rating = Integer.parseInt(request.getParameter("rating"));
			String review = request.getParameter("review");
			Integer productId = Integer.parseInt(request.getParameter("product_id"));
			String keyMessage = request.getParameter("key_message");
			
			Boolean rate = ProductReview.saveProductReview(user.getUserId(),productId,rating,review,keyMessage);
			session.setAttribute("rate",rate);
		
			Gson gson = new Gson();

			String resp = gson.toJson(rate);
			response.getWriter().write(resp);

		}else{
			response.getWriter().write("{\"resp\":0}");
		}
	}
}

