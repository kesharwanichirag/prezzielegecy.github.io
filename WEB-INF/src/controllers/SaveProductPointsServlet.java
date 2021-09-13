package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;
import models.Product;
import models.ProductPoint;

public class SaveProductPointsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		String resp = null;
		User user = (User)session.getAttribute("user");
		if(user!=null){
			String[] pointTitles = request.getParameterValues("prod_ttl");
			String[] pointValues = request.getParameterValues("prod_val");
			
			Product product = (Product)session.getAttribute("product");
			ProductPoint.saveProductPoints(product.getProductId(),pointTitles,pointValues);
			resp = "{\"resp\":1}";
			
		}else{
			resp = "{\"resp\":-1}";
		}
		response.getWriter().write(resp);
	}
}