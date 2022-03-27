package com.application.modul3.order;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.application.modul3.client.Client;

@Entity
@Table(name = "order", schema = "administration")
public class Order {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "date")
	private LocalDate date;

	@Column(name = "nr_items")
	private int nrOfItems;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id", updatable = false)
	private Client client;

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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
