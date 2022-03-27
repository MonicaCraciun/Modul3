package com.application.modul3.appointment.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.appointment.Appointment;
import com.application.modul3.appointment.dto.AppointmentCreateDTO;
import com.application.modul3.appointment.dto.AppointmentDTO;

@Service
public class AppointmentMapper {

	public Appointment appointmentCreateDTO2Appointment(AppointmentCreateDTO appointmentCreateDTO) {
		Appointment appointment = new Appointment();
		appointment.setStartDate(appointmentCreateDTO.getStartDate());
		appointment.setEndDate(appointmentCreateDTO.getEndDate());
		return appointment;
	}

	public AppointmentDTO appointment2AppointmentDTO(Appointment appointment) {
		AppointmentDTO appointmentDTO = new AppointmentDTO();
		appointmentDTO.setId(appointment.getId());
		appointmentDTO.setStartDate(appointment.getStartDate());
		appointmentDTO.setEndDate(appointment.getEndDate());

		return appointmentDTO;
	}

	public List<AppointmentDTO> appointmentList2AppointmentListDTO(List<Appointment> appointments) {
		return appointments.stream().map(appointment -> appointment2AppointmentDTO(appointment))
				.collect(Collectors.toList());
	}

}
