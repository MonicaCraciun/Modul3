package com.application.modul3.appointment.dto;

import java.time.LocalDate;

public class AppointmentInfoDTO {

	private LocalDate startDate;
	private LocalDate endDate;
	private Integer bookId;

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setDateUntil(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

}
