package models;

import java.sql.*;

public class UserFeedback{
	private Integer userFeedbackId;
	private User user;
	private String userMessage;
	private Timestamp date;

	//############ getter setters ##################
	public void setUserFeedbackId(Integer userFeedbackId){
		this.userFeedbackId = userFeedbackId;
	}
	public Integer getUserFeedbackId(){
		return userFeedbackId;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setUserMessage(String userMessage){
		this.userMessage = userMessage;
	}
	public String getUserMessage(){
		return userMessage;
	}

	public void setDate(Timestamp date){
		this.date = date;
	}
	public Timestamp getDate(){
		return date;
	}
}