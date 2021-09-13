package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class ProductPic{
	private Integer productPicId;
	private Product product;
	private String productPic;
	//constructors

	public ProductPic(Integer productPicId,String productPic){
		this.productPicId = productPicId;
		this.productPic = productPic;
	}
	//methods
	public static ArrayList<ProductPic> getAllProductPic(Integer productId){
		ArrayList<ProductPic> pics = new ArrayList<ProductPic>();
		Connection con =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "select product_pic_id ,product_pic from product_pics where product_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,productId);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				pics.add(new ProductPic(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return pics;
	}
	public static String getSinglePicPath(int productId){
		Connection con = null;
		String path = new String();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");

			String query = "select product_pic from product_pics where product_id=? limit 1";
			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setInt(1,productId);

			ResultSet rs = prep.executeQuery();
			if(rs.next()){
				path = rs.getString(1);
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{	
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return path;
	}

	public static void saveProductPic(int productId,ArrayList<String> productPics){
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "insert into product_pics (product_id,product_pic) value (?,?)";
			
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,productId);

			for(String prdPic : productPics){
				prep.setString(2,prdPic);	
				prep.executeUpdate();
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	//getter setters
	public void setProductPicId(Integer productPicId){
		this.productPicId = productPicId;
	}
	public Integer getProductPicId(){
		return productPicId;
	}

	public void setProduct(Product product){
		this.product = product;
	}
	public Product getProduct(){
		return product;
	}

	public void setProductPic(String productPic){
		this.productPic = productPic;
	}
	public String getProductPic(){
		return productPic;
	}

}