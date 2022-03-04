package com.sonata.product.model;

public class Users {
	private String  Role;
	private String  username;
	private String  password;
	
	public Users() {
		super();
	}
	public Users(String role, String username, String password) {
		super();
		this.Role = role;
		this.username = username;
		this.password = password;
	}
	public String getRole() {
		return Role;
	}
	public void setRole(String role) {
		Role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserTable [Role=" + Role + ", username=" + username + ", password=" + password + "]";
	}
	
}
