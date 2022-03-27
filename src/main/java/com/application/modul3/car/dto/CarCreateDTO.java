package com.application.modul3.car.dto;

import java.time.LocalDate;

public class CarCreateDTO {
	private String brand;
	private String model;
	private LocalDate year;
	private int power;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDate getYear() {
		return year;
	}

	public void setYear(LocalDate year) {
		this.year = year;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

}
