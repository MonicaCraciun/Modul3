package com.application.modul3.order.dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.application.modul3.client.Client;

public class OrderDTO {

	private int id;
	private LocalDate date;
	private int nrOfItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getNrOfItems() {
		return nrOfItems;
	}

	public void setNrOfItems(int nrOfItems) {
		this.nrOfItems = nrOfItems;
	}

}
