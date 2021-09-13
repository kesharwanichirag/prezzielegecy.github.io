package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ShowProductPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String picPath = "WEB-INF/uploads/"+request.getParameter("product_pic");
		
		InputStream is = getServletContext().getResourceAsStream(picPath);
		
		OutputStream os = response.getOutputStream();

		byte[] arr = new byte[1024];
		
		int count = 0;

		while((count=is.read(arr))!=-1){
			os.write(arr);
		}
		os.flush();
		os.close();
	}
}