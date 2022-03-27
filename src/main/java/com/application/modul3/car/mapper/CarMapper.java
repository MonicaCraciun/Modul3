package com.application.modul3.car.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.car.Car;
import com.application.modul3.car.dto.CarCreateDTO;
import com.application.modul3.car.dto.CarDTO;

@Service
public class CarMapper {
	
	public CarDTO car2CarDTO(Car car) {
		CarDTO carDTO = new CarDTO();
		carDTO.setId(car.getId());
		carDTO.setBrand(car.getBrand());
		carDTO.setModel(car.getModel());
		carDTO.setPower(car.getPower());
		carDTO.setYear(car.getYear());
		return carDTO;
	}
	
	public Car carDTO2Car(CarDTO carDTO) {
		Car car = new Car();
		car.setId(carDTO.getId());
		car.setBrand(carDTO.getBrand());
		car.setModel(carDTO.getModel());
		car.setPower(carDTO.getPower());
		car.setYear(carDTO.getYear());
		return car;
	}
	
	public Car carCreateDTO2Car(CarCreateDTO carCreateDTO) {
		Car car = new Car();
		car.setBrand(carCreateDTO.getBrand());
		car.setModel(carCreateDTO.getModel());
		car.setPower(carCreateDTO.getPower());
		car.setYear(carCreateDTO.getYear());
		return car;
	}
	
	public List<CarDTO> carList2CarDTOList(List<Car> cars) {
		return cars.stream().map(car -> car2CarDTO(car)).collect(Collectors.toList());
	}
	

}
