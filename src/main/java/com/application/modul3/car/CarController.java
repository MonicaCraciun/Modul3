package com.application.modul3.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.car.dto.CarCreateDTO;
import com.application.modul3.car.dto.CarDTO;
import com.application.modul3.car.mapper.CarMapper;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@Autowired
	private CarMapper carMapper;

	@PostMapping()
	public CarDTO createCar(@RequestBody CarCreateDTO carCreateDTO) {
		Car createCar = carService.createCar(carMapper.carCreateDTO2Car(carCreateDTO));
		return carMapper.car2CarDTO(createCar);
	}

	@PostMapping("/{personId}")
	public CarDTO createCarWithPerson(@RequestBody CarCreateDTO carCreateDTo, @PathVariable Integer personId) {
		Car createCar = carService.createCar(carMapper.carCreateDTO2Car(carCreateDTo), personId);
		return carMapper.car2CarDTO(createCar);
	}

	@GetMapping
	public List<CarDTO> getAllCars() {
		return carMapper.carList2CarDTOList(carService.getAllCars());
	}

	@GetMapping("/{id}")
	public Car getCarById(@PathVariable Integer id) {
		return carService.getCarById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteCarById(@PathVariable Integer carId) {
		carService.deleteCarById(carId);
	}

}
