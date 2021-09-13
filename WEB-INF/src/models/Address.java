package models;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class Address{
	private Integer addressId;
	private User user;
	private String address;
	private City city;
	private String pin;
	private Boolean defaultAddress;
	private String name;
	private String recieverMobile;

	private static final boolean DEFAULT_ADDRESS = true;
	private static final boolean NON_DEFAULT_ADDRESS = false;

	//--------------------
	public Address(){
		
	}
	public Address(User user,City city,String pin,String address){
		this.user = user;
		this.city = city;
		this.pin = pin;
		this.address = address;
		
	}
	public Address(User user){
		this.user = user;
	}
	
	public Address(Integer addressId ,String address,String pin,String name,String recieverMobile,City city){
		this.addressId = addressId;
		this.address = address;
		this.pin = pin;
		this.name = name;
		this.city = city;
		this.recieverMobile = recieverMobile;
	}

	public Address(User user,City city,String pin,String address,String name,String recieverMobile){
		this.user = user;
		this.name = name;
		this.city = city;
		this.pin = pin;
		this.address = address;
		this.recieverMobile = recieverMobile;
	}
	//---------------------
	public static ArrayList getAllAddresses(Integer userId){
		Connection con = null;
		ArrayList<Address> addresses = new ArrayList<Address>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select address_id,address,pin,name,reciever_mobile,c.city_id,city from addresses as a inner join cities as c where a.city_id =c.city_id and user_id=?";
			
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,userId);

			ResultSet rs = prep.executeQuery();
			while(rs.next()){
				addresses.add(new Address(
										rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										new City(rs.getInt(6),rs.getString(7))
								));
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
		return addresses;
	}
	public void showAddress(){
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select * from addresses as a inner join cities as c where a.city_id =c.city_id and user_id=? and default_address=1";
			
			PreparedStatement prep = con.prepareStatement(query);
			prep.setInt(1,user.getUserId());

			ResultSet rs = prep.executeQuery();
			if(rs.next()){
				addressId = rs.getInt(1);
				address = rs.getString(3);
				pin = rs.getString(5);
				name = rs.getString(7);
				city = new City(rs.getInt(9),rs.getString(10));
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

	public boolean saveAddress(){
		Connection con = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "insert into addresses(user_id,address,city_id,pin,default_address,name,reciever_mobile) value (?,?,?,?,?,?,?)";

			PreparedStatement prep = con.prepareStatement(query);
			
			prep.setInt(1,user.getUserId());
			prep.setString(2,address);
			prep.setInt(3,city.getCityId());
			prep.setString(4,pin);
	
			if(name==null){
				prep.setBoolean(5,DEFAULT_ADDRESS);
				prep.setString(6,user.userFullName());
				prep.setString(7,user.getMobile());
			}else{
				prep.setBoolean(5,NON_DEFAULT_ADDRESS);
				prep.setString(6,name);
				prep.setString(7,recieverMobile);
			}
			int rows = prep.executeUpdate();

			if(rows==1){
				flag = true;
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
		return flag;
	}
	//----------------------
	public void setAddressId(Integer addressId){
		this.addressId = addressId;
	}
	public Integer getAddressId(){
		return addressId;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}

	public void setCity(City city){
		this.city = city;
	}
	public City getCity(){
		return city;
	}

	public void setPin(String pin){
		this.pin = pin;
	}
	public String getPin(){
		return pin;
	}

	public void setDefaultAddress(Boolean defaultAddress){
		this.defaultAddress = defaultAddress;
	}
	public Boolean getDefaultAddress(){
		return defaultAddress;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setRecieverMobile(String recieverMobile){
		this.recieverMobile = recieverMobile;
	}

	public String getRecieverMobile(){
		return recieverMobile;
	}
	
}