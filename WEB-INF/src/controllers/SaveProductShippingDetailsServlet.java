package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;
import models.Product;

public class SaveProductShippingDetailsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		String resp ="";
		if(user!=null){	
			String shippingDetails = request.getParameter("product_shipping_details");
			
			Product product = (Product)session.getAttribute("product");
			product.setShippingDetails(shippingDetails);

			if(product.saveShippingDetails()){
				resp += "{\"resp\":1}";
			}else{
				resp += "{\"resp\":0}";
			}
		}else{
			resp += "{\"resp\":-1}";
		}
		response.getWriter().write(resp);
	}
}