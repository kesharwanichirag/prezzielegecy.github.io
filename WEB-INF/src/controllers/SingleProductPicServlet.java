package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.InputStream;

import models.ProductPic;

public class SingleProductPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		Integer productId = Integer.parseInt(request.getParameter("product_id"));
		
		String path = ProductPic.getSinglePicPath(productId);
	
		InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+path);
		OutputStream outputStream = response.getOutputStream();

		byte[] arr = new byte[1024];
		
		int count = 0;

		while((count=inputStream.read(arr))!=-1){
			outputStream.write(arr);
		}
		outputStream.flush();
		outputStream.close();
	}
}