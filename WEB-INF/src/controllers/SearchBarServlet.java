package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.Product;

public class SearchBarServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String searchKey = request.getParameter("search");
		
		ArrayList<Product> rec = Product.searchAllProduct(searchKey);
		Gson gson = new Gson();
		String resp = gson.toJson(rec);
		
		response.getWriter().write(resp);
	}
}