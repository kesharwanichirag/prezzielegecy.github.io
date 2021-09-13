package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.IOException;
import java.util.ArrayList;

import models.Product;

public class ViewMoreTwentyToThirtyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		ArrayList<Product> prd = Product.getProductTwentyToThirty();
		request.setAttribute("pro_cat1",prd);
		System.out.println(prd);
		
		request.getRequestDispatcher("view_more_product2.jsp").forward(request,response);
	}
}