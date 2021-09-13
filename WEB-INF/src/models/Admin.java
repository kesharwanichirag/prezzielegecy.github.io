package models;

import java.sql.*;
import java.util.*;

public class Admin{
	private Integer adminId;
	private String adminKey;
	private String adminPin;

	public Admin(String adminKey,String adminPin){
		this.adminKey = adminKey;
		this.adminPin = adminPin;
	}
	
	public String loginAdmin(){
		String admin = "";
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select admin_key,admin_pin from admin where admin_key=? and admin_pin=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,adminKey);
			pst.setString(2,adminPin);

			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				String psw = rs.getString(2);
				if(adminPin.equals(psw)){
					adminKey = rs.getString(1);
					admin += "done";
				}else{
					admin += "not done";	
				}
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
		return admin;
	}

	public void setAdminId(Integer adminId){
		this.adminId = adminId;
	}
	public Integer getAdminId(){
		return adminId;
	}

	public void setAdminKey(String adminKey){
		this.adminKey = adminKey;
	}
	public String getAdminKey(){
		return adminKey;
	}

	public void setAdminPin(String adminPin){
		this.adminPin = adminPin;
	}
	public String getAdminPin(){
		return adminPin;
	}
}