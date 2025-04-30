package com.anand.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
    @NotEmpty(message = "Name is Mandatory")
	private String name;
    @NotEmpty(message = "Email is Mandatory")
    @Email(message = "give valid Email ID")
	private String email;
    @NotNull(message ="Phone Number is Mandatory" )
	private long phone;
	
	@CreationTimestamp
	@Column(updatable = false)
	private LocalDate createdAt;
	
	@UpdateTimestamp
	@Column(insertable = false)
	private LocalDate updatedAt;
	
	public User() {
          System.out.println("0 parameter User");
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
}
