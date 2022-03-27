package com.application.modul3.car;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.modul3.person.Person;
import com.application.modul3.person.PersonService;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private PersonService personService;

	public Car createCar(Car car) {
		return carRepository.saveAndFlush(car);
	}

	public Car createCar(Car car, Integer personId) {
		Person person = personService.getPersonById(personId);
		person.addCar(car);
		car.setPerson(person);
		return carRepository.saveAndFlush(car);
	}

	public Car getCarById(Integer id) {
		Optional<Car> optionalCar = carRepository.findById(id);
		if (optionalCar.isPresent()) {
			return optionalCar.get();
		}
		return null;
	}

	public void deleteCarById(Integer carId) {
		carRepository.deleteById(carId);
	}

	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	public void removeCarFromUser(Integer personId, Integer carId) {
		Person person = personService.getPersonById(personId);
		Car car = getCarById(carId);
		person.removeCar(car);
		carRepository.flush();
	}

}
