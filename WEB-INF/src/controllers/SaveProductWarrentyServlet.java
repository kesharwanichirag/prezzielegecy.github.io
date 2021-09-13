package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;
import models.Product;

public class SaveProductWarrentyServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		String resp ="";
		if(user!=null){	
			String warranty = request.getParameter("product_warranty");
			
			Product product = (Product)session.getAttribute("product");
			product.setWarranty(warranty);

			if(product.saveWarranty()){
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