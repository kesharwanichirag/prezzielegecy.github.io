package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

import models.User;

public class SaveProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
			
		User user = (User)session.getAttribute("user");

		OutputStream os = response.getOutputStream();
		
		String profPicPath = "static/images/user.png";

		if(user!=null){
			String profPic = user.getProfPic();
			
			profPicPath = "/WEB-INF/uploads/"+profPic;
		}

		InputStream is = getServletContext().getResourceAsStream(profPicPath);
		
		byte[] byt = new byte[1024];
		
		int count = 0;

		while((count=is.read(byt))!=-1){
			os.write(byt);
		}
		os.flush();
		os.close();
	}
}