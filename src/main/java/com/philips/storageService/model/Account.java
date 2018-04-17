package com.philips.storageservice.model;

public class Account {
	private String accountid;
	private String email;
	private String firstName;
    private String lastName;

    public Account(String accountid, String email, String firstName, String lastName){
        this.accountid = accountid;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;        
    }

    public void setId(String accountid){
		this.accountid = accountid;
	}
	
	public String getId(){
		return this.accountid;
	}
	
	public void setFirstname(String firstname){
		this.firstName = firstname;
	}
	
	public String getFirstname(){
		return this.firstName;
	}
	
	public void setLastname(String lastname){
		this.lastName = lastname;
	}
	
	public String getLastname(){
		return this.lastName;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return this.email;
    }
    
    @Override
	public String toString() {
        return String.format("Account[AccountId=%s, FirstName='%s', LastName='%s', Email=%s]", 
        this.accountid.toString(), this.firstName, this.lastName, this.email);
	}
}