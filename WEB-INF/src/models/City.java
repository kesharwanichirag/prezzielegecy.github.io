package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.util.ArrayList;

public class City{
	private Integer cityId;
	private String city;
	private State stateId;

	//-------constructors---------
	
	public City(){

	}
	public City(Integer cityId,String city){
		this.cityId = cityId;
		this.city = city;
	}

	public City(Integer cityId){
		this.cityId = cityId;
	}
	//--------others--------------
	
	
	
	
	
	public static ArrayList<City> searchCity(String sKey){
		ArrayList<City> cities = new ArrayList<City>();
		Connection con = null;	

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
 
			String query = "select city_id,city from cities where city like '"+sKey+"%'";

			PreparedStatement prep = con.prepareStatement(query);
			
			ResultSet rs = prep.executeQuery();
			while(rs.next()){

				City cty = new City(rs.getInt(1),rs.getString(2));
				cities.add(cty);	
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
		return cities;
	}
	
	
	
	
	
	
	
	
	
	
	
	//--------getter setter method--------------
	public void setCityId(Integer cityId){
		this.cityId= cityId;
	}
	public Integer getCityId(){
		return cityId;
	}
	
	public void setCity(String city){
		this.city= city;
	}
	public String getCity(){
		return city;
	}

	public void setStateId(State stateId){
		this.stateId= stateId;
	}
	public State getStateId(){
		return stateId;
	}
	
}