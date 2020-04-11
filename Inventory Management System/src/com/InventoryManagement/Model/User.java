package com.InventoryManagement.Model;

public class User {

	private int Id;
	private String Name;
	private String Email;
	private String Password; 
	private String Gender;
	
	public User(int id, String name, String email, String password, String gender) {
		super();
		Id = id;
		Name = name;
		Email = email;
		Password = password;
		Gender = gender;
	}
	
	public User(int id) {
		super();
		Id = id;
	}


	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}


	@Override
	public String toString() {
		return "User [Id=" + Id + ", Name=" + Name + ", Email=" + Email + ", Password=" + Password + ", Gender="
				+ Gender + "]";
	}

	public User() {
		
	}
	
	
	
}
