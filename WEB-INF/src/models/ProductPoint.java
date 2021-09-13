package models;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProductPoint{
	private Integer productPointId;
	private Product product;
	private String pointHeader;
	private String pointValue;
	//constructors
	public ProductPoint(){
		
	}
	public ProductPoint(String pointHeader,String pointValue){
		this.pointHeader = pointHeader;
		this.pointValue = pointValue;
	}
	//methods
	public static ArrayList<ProductPoint> getProductPoints(Integer productId){
		Connection con = null;
		ArrayList<ProductPoint> points = new ArrayList<ProductPoint>();

		try{
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");

			String query = "select point_header,point_value from product_points where product_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,productId);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				points.add(new ProductPoint(rs.getString(1),rs.getString(2)));
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
		return points;
	}
	public static void saveProductPoints(Integer productId,String[] pointTitles,String[] pointValues){
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			String query = "insert into product_points (product_id,point_header,point_value) values(?,?,?)";
			
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,productId);

			for(int i=0;i<pointTitles.length;i++){
				prep.setString(2,pointTitles[i]);
				prep.setString(3,pointValues[i]);
				
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
	//getters-setters
	public void setProductPointId(Integer productPointId){
		this.productPointId = productPointId;
	}
	public Integer getProductPointId(){
		return productPointId;
	}

	public void setProduct(Product product){
		this.product = product;
	}
	public Product getProduct(){
		return product;
	}

	public void setPointHeader(String pointHeader){
		this.pointHeader = pointHeader;
	}
	public String getPointHeader(){
		return pointHeader;
	}

	public void setPointValue(String pointValue){
		this.pointValue = pointValue;
	}
	public String getPointValue(){
		return pointValue;
	}
	
}