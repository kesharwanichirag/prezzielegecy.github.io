package controllers;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.IOException;
import java.util.ArrayList;

import models.Product;

public class ViewMoreThirtyPlusServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		ArrayList<Product> prd = Product.getProductThirtyPlus();
		request.setAttribute("pro_cat2",prd);
		
		request.getRequestDispatcher("view_more_product3.jsp").forward(request,response);
	}
}