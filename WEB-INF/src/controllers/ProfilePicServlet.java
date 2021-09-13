package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import java.io.IOException;
import java.io.File;
import java.util.List;

import models.User;

public class ProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request ,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		if(user!=null){
			request.getRequestDispatcher("profile_pic.jsp").forward(request,response);		
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory dsif = new DiskFileItemFactory();

				ServletFileUpload sfu = new ServletFileUpload(dsif);

				List<FileItem> items = null;
				try{
					items = sfu.parseRequest(request);
				}catch(FileUploadException e){
					e.printStackTrace();
				}

				FileItem fileItem = items.get(0);

				String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName());

				File file = new File(uploadPath,fileItem.getName());

				try{
					fileItem.write(file);
					user.setProfPic(user.getUserName()+"/"+fileItem.getName());
					
					user.saveProfPic();
				}catch(Exception e){
					e.printStackTrace();
				}
			}	
			response.sendRedirect("profile_pic.do");
		}else{
			response.sendRedirect("login.do");
		}
	}
}