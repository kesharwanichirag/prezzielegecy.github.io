package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.File;

import com.google.gson.Gson;

import models.User;
import models.Seller;
import models.Product;
import models.Category;

public class NewProductServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			request.getRequestDispatcher("new_products.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			String productName = request.getParameter("product_name");
			
			if(productName!=null){
				try{
					int categoryId = Integer.parseInt(request.getParameter("category_id"));
					int productQuantity = Integer.parseInt(request.getParameter("product_quantity"));
					int productPrice = Integer.parseInt(request.getParameter("product_price"));
					int productDiscount = Integer.parseInt(request.getParameter("product_discount"));
					
					//from SellerDashboardServlet
					Seller seller = (Seller)session.getAttribute("seller");
					
					Product product = new Product(seller,productName,new Category(categoryId),productQuantity,productPrice,productDiscount);
					
					if(product.saveProduct()){
						String realPath = getServletContext().getRealPath("/WEB-INF/uploads"+user.getUserName()+"/"+seller.getSellerAccountName());
						String uploadPath = product.getProductName();
						File file = new File(realPath,uploadPath);
						file.mkdir();
						
						session.setAttribute("product",product);
						Gson gson = new Gson();

						String resp = gson.toJson(product);
						response.getWriter().write(resp);
					}else{
						response.getWriter().write("{}");
					}
				}catch(NumberFormatException e){
					e.printStackTrace();
					response.getWriter().write("{}");
				}
			}
		}else{
			response.getWriter().write("{\"resp\":0}");
		}
	}	
}