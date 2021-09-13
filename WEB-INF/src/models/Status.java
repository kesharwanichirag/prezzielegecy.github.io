package models;

public class Status{
	private Integer statusId;
	private String status;
	
	//-----------constructors----------
	public Status(){

	}
	public Status(Integer statusId){
		this.statusId= statusId;
	}
	
	//-------------setter getter-------------

	public void setStatusId(Integer statusId){
		this.statusId = statusId;
	}

	public Integer getStatusId(){
		return statusId;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}