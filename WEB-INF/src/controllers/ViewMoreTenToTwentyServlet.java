package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.IOException;
import java.util.ArrayList;

import models.Product;

public class ViewMoreTenToTwentyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		ArrayList<Product> prd = Product.getProductTenToTwenty();
		request.setAttribute("pro_cat",prd);
		
		request.getRequestDispatcher("view_more_product.jsp").forward(request,response);
	}
}