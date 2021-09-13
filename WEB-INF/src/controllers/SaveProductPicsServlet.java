package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;

import models.User;
import models.Seller;
import models.Product;
import models.ProductPic;

public class SaveProductPicsServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory dfif = new DiskFileItemFactory();

				ServletFileUpload sfu = new ServletFileUpload(dfif);
				List <FileItem> fileItems = null;
				
				try{
					fileItems = sfu.parseRequest(request);
					
					Product product = (Product)session.getAttribute("product");
					Seller seller = (Seller)session.getAttribute("seller");
					
					String dbPicPath = user.getUserName()+"/"+seller.getSellerAccountName()+"/"+product.getProductId()+"/";
					
					ArrayList<String> dbPicPaths = new ArrayList<String>();
					String realPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName()+"/"+seller.getSellerAccountName()+"/"+product.getProductId());
					
					for(FileItem fileItem:fileItems){
						String fileName = fileItem.getName();
						
						dbPicPaths.add(dbPicPath+fileName);
						
						try{	
							File file = new File(realPath,fileName);
							
							fileItem.write(file);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
					ProductPic.saveProductPic(product.getProductId(),dbPicPaths);
					
					response.sendRedirect("my_products.jsp");
				
				}catch(FileUploadException e){
					e.printStackTrace();
				}
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}