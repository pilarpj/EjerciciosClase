package com.esail.models;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class User {
	@Id
	@GeneratedValue
	private int id;
	private String userName; 
	private String pass;
	
	public User(int id, String userName, String pass) {
		this.id = id;
		this.userName = userName;
		this.pass = pass;
		
	}
	
	public User() {
		this.id = 0;
		this.userName = "-";
		this.pass = "*";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", pass=" + pass + "]";
	}

}
