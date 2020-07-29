package com.vir.model;

public class User {
	private String name ;
	private String givenName;
	private String familyName;
	private String email;
	
	
	
//	public User(String name, String givenName, String familyName, String email) {
//		super();
//		this.name = name;
//		this.givenName = givenName;
//		this.familyName = familyName;
//		this.email = email;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
//	@Override
//	public String toString() {
//		return "User [name=" + name + ", givenName=" + givenName + ", familyName=" + familyName + ", email=" + email
//				+ "]";
//	}
//	
	
}
