package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Set;

import com.google.gson.Gson;

import utils.ProductCount;

public class AddToCartServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		Integer productId = Integer.parseInt(request.getParameter("product_id"));
		Integer quantity = Integer.parseInt(request.getParameter("quantity"));
		
		Map<Integer,Integer> crt = (Map<Integer,Integer>)session.getAttribute("cart");
		
		if(crt==null){
			crt = new LinkedHashMap<Integer,Integer>();
			session.setAttribute("cart",crt);
		}
		crt.put(productId,quantity);
		
		Set<Integer> set = crt.keySet();
		int cartCount = 0;
		for(Integer key : set){
			cartCount += crt.get(key);
		}
		session.setAttribute("cartcount",cartCount);
		
		ProductCount prc = new ProductCount(cartCount);
		Gson gson = new Gson();
		String resp = gson.toJson(prc);

		response.getWriter().write(resp);
	}
}