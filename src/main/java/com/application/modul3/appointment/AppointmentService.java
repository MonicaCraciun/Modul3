package com.application.modul3.appointment;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.exception.ResourceNotFoundException;
import com.application.modul3.exception.ValidationException;
import com.application.modul3.exemplary.Exemplary;
import com.application.modul3.exemplary.ExemplaryRepository;
import com.application.modul3.user.User;
import com.application.modul3.user.UserRepository;

@Service
public class AppointmentService {

	@Autowired
	private AppointmentRepository appointmentRepository;
	@Autowired
	private ExemplaryRepository exemplaryRepository;
	@Autowired
	private UserRepository userRepository;

	public Set<Appointment> getAllAppointmentsForUser(Integer userId) {
		return appointmentRepository.findByUser(userId);
	}

	public List<Exemplary> getExemplariesForPeriod(LocalDate dateFrom, LocalDate dateUntil, Integer bookId) {
		return exemplaryRepository.getExemplariesForPeriod(dateFrom, dateUntil, bookId);
	}

	public void book(Appointment appointment, Integer exemplaryId, Integer userId) {
		if (appointment.getStartDate().isAfter(appointment.getEndDate())) {
			throw new ValidationException("End date of the appointment is before start date");
		}

		Exemplary exemplary = exemplaryRepository.findById(exemplaryId)
				.orElseThrow(() -> new ResourceNotFoundException("Exemplary not found"));
		User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));

		if (!getExemplariesForPeriod(appointment.getStartDate(), appointment.getEndDate(), exemplary.getBook().getId())
				.contains(exemplary)) {
			throw new ValidationException("The exemplary was reserved by somebody else");
		}

		exemplary.addAppointment(appointment);
		user.addAppointment(appointment);

		appointmentRepository.saveAndFlush(appointment);
	}
}
