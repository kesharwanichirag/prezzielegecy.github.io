package models;

public class State{
	//----fields-------
	private Integer stateId;
	private String state;
	
	//----constructors--------
	


	//--------getters setters---------
	
	public void setStateId(Integer stateId){
		this.stateId = stateId;
	}
	public Integer getStateId(){
		return stateId;
	}

	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return state;
	}
}