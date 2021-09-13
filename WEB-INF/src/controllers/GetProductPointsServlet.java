package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.ProductPoint;

public class GetProductPointsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		Integer productId = Integer.parseInt(request.getParameter("product_id"));	
		
		ArrayList<ProductPoint> points = ProductPoint.getProductPoints(productId);
		Gson gson = new Gson();

		String rsp = gson.toJson(points);
		
		response.getWriter().write(rsp);
	}
}