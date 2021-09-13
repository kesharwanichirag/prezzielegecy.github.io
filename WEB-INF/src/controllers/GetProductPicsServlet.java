package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.ProductPic;

public class GetProductPicsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		Integer productId = Integer.parseInt(request.getParameter("product_id"));

		ArrayList<ProductPic> pics = ProductPic.getAllProductPic(productId);
		
		Gson gson = new Gson();
		String resp = gson.toJson(pics);
		
		response.getWriter().write(resp);
	}
}