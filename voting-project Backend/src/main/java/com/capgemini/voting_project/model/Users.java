package com.capgemini.voting_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	 
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Min(value=18,message="minimum age required 18")
	@JsonProperty("Age")
	private Long age;
	
	@NotBlank(message = "Constituency is mandatory")
	 @JsonProperty("Constituency")
	
	private String constituency;
	
	@NotBlank(message = "email is mandatory")
	private String email;
	
	@NotBlank(message = "phone number is mandatory")
	private String phone;
	
	@NotBlank(message = "password is mandatory")
	private String password;
	
	@NotBlank(message = "voterId is mandatory")
	private String voterId;
	
	@NotBlank(message = "userType is mandatory")
	private String userType;
	
	public Users() {
		
	}

	public Users(Long id, @NotBlank(message = "Name is mandatory") String name,
			@Min(value = 18, message = "minimum age required 18") Long age,
			@NotBlank(message = "Constituency is mandatory") String constituency,
			@NotBlank(message = "email is mandatory") String email,
			@NotBlank(message = "phone number is mandatory") String phone,
			@NotBlank(message = "password is mandatory") String password,
			@NotBlank(message = "voterId is mandatory") String voterId,
			@NotBlank(message = "userType is mandatory") String userType) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.constituency = constituency;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.voterId = voterId;
		this.userType = userType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getConstituency() {
		return constituency;
	}

	public void setConstituency(String constituency) {
		this.constituency = constituency;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getVoterId() {
		return voterId;
	}

	public void setVoterId(String voterId) {
		this.voterId = voterId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", Age=" + age + ", Constituency=" + constituency + ", email="
				+ email + ", phone=" + phone + ", password=" + password + ", voterId=" + voterId + ", userType="
				+ userType + "]";
	}
	
	

}
