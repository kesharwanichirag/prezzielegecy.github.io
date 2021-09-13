package models;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.Date;
import java.util.ArrayList;

public class Seller{
	//fields
	private Integer sellerId;
	private User user;
	private String sellerAccountName;
	private Timestamp startDate;
	private String buisnessType;

	//constructors
	public Seller(){

	}

	public Seller(Integer sellerId,String sellerAccountName){
		this.sellerId = sellerId;
		this.sellerAccountName = sellerAccountName;
	}

	public Seller(Integer sellerId,String sellerAccountName,Timestamp startDate,String buisnessType){
		this.sellerId = sellerId;
		this.sellerAccountName = sellerAccountName;
		this.startDate = startDate;
		this.buisnessType = buisnessType;
	}
	//methods
	public static ArrayList<Seller> showSellerAccounts(Integer userId){
		ArrayList<Seller> seller = new ArrayList<Seller>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from sellers where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,userId);

			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				seller.add(new Seller(rs.getInt(1),rs.getString(3),rs.getTimestamp(4),rs.getString(5)));
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
		return seller;
	}

	public static boolean createNewSeller(User user,String sellerAccountName,String buisnessType){
		boolean flag = false;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "insert into sellers(user_id,seller_account_name,start_date,buisness_type) value (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);

			pst.setInt(1,user.getUserId());
			pst.setString(2,sellerAccountName);
			
			Date date = new Date();
			Timestamp stmp = new Timestamp(date.getTime());
			pst.setTimestamp(3,stmp);

			pst.setString(4,buisnessType);
			
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

	//getter setters
	public void setSellerId(Integer sellerId){
		this.sellerId = sellerId;
	}
	public Integer getSellerId(){
		return sellerId;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setSellerAccountName(String sellerAccountName){
		this.sellerAccountName = sellerAccountName;
	}
	public String getSellerAccountName(){
		return sellerAccountName;
	}

	public void setStartDate(Timestamp startDate){
		this.startDate = startDate;
	}
	public Timestamp getStartDate(){
		return startDate;
	}

	public void setBuisnessType(String buisnessType){
		this.buisnessType = buisnessType;
	}
	public String getBuisnessType(){
		return buisnessType;
	}
}
