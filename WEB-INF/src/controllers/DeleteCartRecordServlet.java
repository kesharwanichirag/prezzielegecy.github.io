package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.ServletException;

import java.io.IOException;
import java.util.Map;

public class DeleteCartRecordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		Integer productId = Integer.parseInt(request.getParameter("product_id"));
		
		Map<Integer,Integer> cart = (Map<Integer,Integer>) session.getAttribute("cart");
		
		cart.remove(productId);

		response.getWriter().write("{\"done\":\"true\"}");
	}
}