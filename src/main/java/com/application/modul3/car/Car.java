package com.application.modul3.car;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.application.modul3.person.Person;
@Entity
@Table(name = "car", schema = "administration")
public class Car {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "brand")
	private String brand;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "year")
	private LocalDate year;
	
	@Column(name = "power")
	private int power;
	
	@ManyToOne()
	@JoinColumn(name = "person_id")
	private Person person;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public LocalDate getYear() {
		return year;
	}
	public void setYear(LocalDate year) {
		this.year = year;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Person getPerson() {
		return person;
	}

}
