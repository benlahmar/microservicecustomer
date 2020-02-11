package com.gr.moi.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Account{
	@Id
	@GeneratedValue
	Long id;
	String username,password,role;
	
	@JsonBackReference
	@ManyToOne
	Profil profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Profil getProfile() {
		return profile;
	}

	public void setProfile(Profil profile) {
		this.profile = profile;
	}
	
	
}
