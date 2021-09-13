package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class ProductReview{
	private Integer productReviewId;
	private User user;
	private Product product;
	private Integer userRating;
	private String userReview;
	private Timestamp date;
	private String keyMessage;
	
	public ProductReview(Integer productReviewId,Integer userRating,String userReview,Timestamp date,String keyMessage){
		this.productReviewId = productReviewId;
		this.userRating = userRating;
		this.userReview = userReview;
		this.date = date;
		this.keyMessage = keyMessage;
	}

	public ProductReview(Integer userRating){
		this.userRating = userRating;
	}

	//methods
	public static LinkedList countRating(Integer productId){
		Connection con = null;
		LinkedList<ProductReview> count = new LinkedList<ProductReview>();
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select user_rating from product_reviews where product_id=?";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,productId);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				count.add(new ProductReview(rs.getInt(1)));
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
		return count;
	}
	/*public static ArrayList<ProductReview> getAverageRating(Integer productId){
		ArrayList<ProductReview> rates = new ArrayList<ProductReview>();
		Connection con = null;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select AVG(user_rating) from product_reviews where product_id=?";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,productId);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				rates.add(new ProductReview(rs.getInt(1)));
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
		return rates;
	}*/
	
	public static ArrayList<ProductReview> showProductRatings(Integer productId){
		ArrayList<ProductReview> rates = new ArrayList<ProductReview>();
		Connection con = null;
		try{	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select product_reviews_id,user_rating,user_review,date,key_message from product_reviews where product_id=?";
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,productId);
			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				rates.add(new ProductReview(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getTimestamp(4),rs.getString(5)));
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
		return rates;
	}

	public static boolean saveProductReview(Integer userId,Integer productId,Integer rating,String review,String keyMessage){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "insert into product_reviews (user_id,product_id,user_rating,user_review,key_message) values(?,?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setInt(2,productId);
			pst.setInt(3,rating);
			pst.setString(4,review);
			pst.setString(5,keyMessage);

			pst.executeUpdate();

			flag = true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	//getter-setters
	public void setProductReviewId(Integer productReviewId){
		this.productReviewId = productReviewId;
	}
	public Integer getProductReviewId(){
		return productReviewId;
	}

	public void setUserId(User user){
		this.user = user;
	}

	public User getUserId(){
		return user;
	}

	public void setProductId(Product product){
		this.product = product;
	}

	public Product getProductId(){
		return product;
	}

	public void setUserRating(Integer userRating){
		this.userRating = userRating;
	}

	public Integer getUserRating(){
		return userRating;
	}

	public void setUserReview(String userReview){
		this.userReview = userReview;
	}

	public String getUserReview(){
		return userReview;
	}
}