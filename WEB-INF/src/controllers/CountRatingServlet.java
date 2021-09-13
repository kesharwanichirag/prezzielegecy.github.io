package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.LinkedList;

import models.User;
import models.ProductReview;

import com.google.gson.Gson;

public class CountRatingServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		Integer productId = Integer.parseInt(request.getParameter("product_id"));	

		LinkedList<ProductReview> ratings = ProductReview.countRating(productId);
		Gson gson = new Gson();
	
		String rsp = gson.toJson(ratings);
		
		response.getWriter().write(rsp);
	}
}

