package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Category{
	private Integer categoryId;
	private String category;
	
	//constructors
	public Category(){
		
	}
	public Category(Integer categoryId,String category){
		this.categoryId = categoryId;
		this.category = category;
	}

	public Category(Integer categoryId){
		this.categoryId = categoryId;
	}

		
	//methods
	//--------------------------------------------------
	public static ArrayList<Category> showCatForCart(){
		Connection connection = null;
		ArrayList<Category> categories = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from categories order by rand() limit 20";

			PreparedStatement prep = connection.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categories;
	}
	//--------------------------------------------------
	public static ArrayList<Category> showCategories6(){
		Connection connection = null;
		ArrayList<Category> categories = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from categories where category_id between 64 and 68";

			PreparedStatement prep = connection.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categories;
	}

	public static ArrayList<Category> showCategories5(){
		Connection connection = null;
		ArrayList<Category> categories = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from categories where category_id between 53 and 59";

			PreparedStatement prep = connection.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categories;
	}

	public static ArrayList<Category> showCategories4(){
		Connection connection = null;
		ArrayList<Category> categories = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from categories where category_id between 50 and 52";

			PreparedStatement prep = connection.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categories;
	}

	public static ArrayList<Category> showCategories3(){
		Connection connection = null;
		ArrayList<Category> categories = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from categories where category_id between 46 and 49";

			PreparedStatement prep = connection.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categories;
	}

	public static ArrayList<Category> showCategories2(){
		Connection connection = null;
		ArrayList<Category> categories = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from categories where category_id between 38 and 45";

			PreparedStatement prep = connection.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categories;
	}

	public static ArrayList<Category> showCategories1(){
		Connection connection = null;
		ArrayList<Category> categories = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from categories where category_id between 25 and 32";

			PreparedStatement prep = connection.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categories;
	}

	public static ArrayList<Category> getCategories(){
		Connection connection = null;
		ArrayList<Category> categories = new ArrayList<Category>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from categories";

			PreparedStatement prep = connection.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			
			while(rs.next()){
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return categories;
	}

	// getter-setters
	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}
	public Integer getCategoryId(){
		return categoryId;
	}

	public void setCategory(String category){
		this.category = category;
	}
	public String getCategory(){
		return category;
	}
}