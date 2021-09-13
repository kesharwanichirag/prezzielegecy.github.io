package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class User{	
	//-------------fields-----------------
	private Integer userId;
	private String userName;
	private String mobile;
	private String email;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private Status status;
	private UserType userType;
	private String activationCode;
	private String profPic;
	//------------constructors------------
	public User(){
		super();
	}
	
	public User(Integer userId,String userName,String email,String mobile,Status status, String profilePic){
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.profPic = profPic;
	}

	public User(Integer userId,String userName,String email,String mobile,Status status, String profilePic,String firstName,String middleName,String lastName){
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobile = mobile;
		this.status = status;
		this.profPic = profPic;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}
	
	//---------------other methods----------------
	public static String unBlockUser(Integer userId){
		String flag = "";
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set status_id=1 where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			
			int count = pst.executeUpdate();
			if(count==1){
				flag+= "done";
			}else{
				flag+= "not done";
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

	public static String blockUser(Integer userId){
		String flag = "";
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set status_id=4 where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			
			int count = pst.executeUpdate();
			if(count==1){
				flag+= "done";
			}else{
				flag+= "not done";
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

	public static User getUserDetilsForAdmin(Integer userId){
		//ArrayList<User> users = new ArrayList<User>();
		User user = null;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select user_id,username,email,mobile,status_id,profile_pic,first_name,middle_name,last_name from users where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),(new Status(rs.getInt(5))),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
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
		return user;
	}

	public static ArrayList<User> getAllUsersForAdmin(){
		ArrayList<User> users = new ArrayList<User>();
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select user_id,username,email,mobile,status_id,profile_pic from users";
			PreparedStatement pst = con.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				users.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),new Status(rs.getInt(5)),rs.getString(6)));
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
		return users;
	}
	public static boolean changeUserName(Integer userId,String userName){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set username=? where user_id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,userName);
			pst.setInt(2,userId);
			
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
	public static boolean changeEmail(Integer userId,String email){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set email=? where user_id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,email);
			pst.setInt(2,userId);
			
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
	public static boolean removeProfilePic(Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set profile_pic='user//user_profile.png' where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);

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

	public static boolean changePassword(Integer userId,String password){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set password=? where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			StrongPasswordEncryptor encp = new StrongPasswordEncryptor();
		
			pst.setString(1,encp.encryptPassword(password));
			pst.setInt(2,userId);

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
	public static String checkPassword(String oldPassword,Integer userId){
		String user = null;
		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select password from users where user_id=?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);

			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				String psw = rs.getString(1);
				StrongPasswordEncryptor encp = new StrongPasswordEncryptor();
				if(encp.checkPassword(oldPassword,psw)){
					user = "success..";
				}else{
					user = "Incorrect Password..!";
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
		return user;
	}

	public static boolean forgotPassword(String eml,String password){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set password=? where email=?";

			PreparedStatement pst = con.prepareStatement(query);
			StrongPasswordEncryptor encp = new StrongPasswordEncryptor();
		
			pst.setString(1,encp.encryptPassword(password));
			pst.setString(2,eml);

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

	public String userFullName(){
		return firstName+" "+middleName+" "+lastName;
	} 

	public boolean saveProfPic(){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set profile_pic=? where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,profPic);
			pst.setInt(2,userId);

			pst.executeUpdate();

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

	public boolean saveProfile(){
		boolean flag = false;

		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
		
			String query= "update users set first_name=?,middle_name=?,last_name=?,mobile=? where user_id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,firstName);
			pst.setString(2,middleName);
			pst.setString(3,lastName);
			pst.setString(4,mobile);
			pst.setInt(5,userId);
				
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

	public String userLogin(String userNameEmail, String password){
		String message = null;
		Connection connection = null;
		
		User user = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "select password,status_id,user_id,username,email,first_name,middle_name,last_name,mobile,user_type_id,profile_pic from users where (username=? or email =?)";

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,userNameEmail);
			pst.setString(2,userNameEmail);

			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				String psw = rs.getString(1);
				StrongPasswordEncryptor encp = new StrongPasswordEncryptor();
				if(encp.checkPassword(password,psw)){
					if(rs.getInt(2)==1){
						status = new Status(rs.getInt(2));
						userId = rs.getInt(3);
						userName = rs.getString(4);
						email = rs.getString(5);
						firstName = rs.getString(6);
						middleName = rs.getString(7);
						lastName = rs.getString(8);
						mobile = rs.getString(9);
						userType = new UserType(rs.getInt(10));
						//user.setStatus(new Status(rs.getInt(10)));
						profPic = rs.getString(11);
					
						message = "Login Success...!";
					}else{
						message = "Either your account is Inactive (Check Mail-Id) or Blocked...!";
					}
				}else{
					message = "Incorrect Password..!";
				}
			}else{
				message = "Account with this data not found..!";
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
		return message;
	}
	public static boolean uniqueKey(String key){
		boolean flag = false;

		Connection con = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
		
			String query= "select user_id from users where username=? or email=?";
						
			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setString(1,key);
			pst.setString(2,key);
				
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
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
	

	public static boolean activateAccount(String userName ,String activationCode){
		Connection connection = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "update users set status_id=1,activation_code='' where username=? and activation_code=?";

			PreparedStatement prep = connection.prepareStatement(query);

			prep.setString(1,userName);
			prep.setString(2,activationCode);
			
			int result = prep.executeUpdate();
			
			if(result==1){
				flag = true;
			}

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	
	}
	
	public static boolean saveUser(String userName, String email, String password, String activationCode){
		boolean flag = false;
		
		Connection connection = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/giftdb?user=root&password=1234");
			
			String query = "insert into users (username,email,password,activation_code) value (?,?,?,?)";

			PreparedStatement prep = connection.prepareStatement(query);

			prep.setString(1,userName);
			prep.setString(2,email);
			StrongPasswordEncryptor encp = new StrongPasswordEncryptor();
			prep.setString(3,encp.encryptPassword(password));
			prep.setString(4,activationCode);
			
			prep.executeUpdate();
			
			flag = true;

		}catch(ClassNotFoundException|SQLException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	//------------getter setters------------
	
		//1 
	public void setUserId(Integer userId){
		this.userId = userId;
	}

	public Integer getUserId(){
		return userId;
	}
	
		//2
	public void setUserName(String userName){
		this.userName = userName;
	}

	public String getUserName(){
		return userName;
	}
		//3
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
		//4
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

		//5
	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
	

		//6
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName(){
		return firstName;
	}
	
		//7
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMiddleName(){
		return middleName;
	}

		//8
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName(){
		return lastName;
	}
		//9
	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}
		//10
	public void setUserType(UserType userType){
		this.userType = userType;
	}

	public UserType getUserType(){
		return userType;
	}
		//11
	public void setActivationCode(String activationCode){
		this.activationCode = activationCode;
	}
	public String getActivationCode(){
		return activationCode;
	}

		//12
	public void setProfPic(String profPic){
		this.profPic = profPic;
	}
	public String getProfPic(){
		return profPic;
	}
}