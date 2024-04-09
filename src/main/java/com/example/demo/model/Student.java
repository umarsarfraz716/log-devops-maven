package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="student")
@NoArgsConstructor
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrollment;
	@Column(name = "amount")
	private double amount;
	@Column(name = "catagory")
	private String catagory;
	
	public double getAmount() {
		return this.amount;
	}
	
	public String getCatagory() {
		return this.catagory;
	}
	
	public void setAmount(double amt) {
		this.amount= amt;
	}
	
	public void setCatagory(String catagory) {
		this.catagory= catagory;
	}
	
	
}
