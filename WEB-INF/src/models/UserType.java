package models;

public class UserType{
	private Integer userTypeId;
	private String userType;

	//-------constructors--------
	public UserType(){

	}
	public UserType(Integer userTypeId){
		this.userTypeId = userTypeId;
	}

	//---------setter getter--------------
		//1
	public void setUserTypeId(Integer userTypeId){
		this.userTypeId = userTypeId;
	}
	public Integer getUserTypeId(){
		return userTypeId;
	}

		//2
	public void setUserType(String userType){
		this.userType = userType;
	}
	public String getUserType(){
		return userType;
	}
	
}