package com.application.modul3.person;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.modul3.car.CarService;
//import com.application.modul3.course.CourseService;
import com.application.modul3.person.dto.PersonCreateDTO;
import com.application.modul3.person.dto.PersonDTO;
import com.application.modul3.person.mapper.PersonMapper;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonMapper personMapper;

	@Autowired
	private CarService carService;
	
//	@Autowired
//	private CourseService courseService;

	@PostMapping()
	public PersonDTO createPerson(@RequestBody PersonCreateDTO personCreateDTO) {
		Person createPerson = personService.createPerson(personMapper.personCreateDTO2Person(personCreateDTO));
		return personMapper.person2PersonDTO(createPerson);
	}

//	@GetMapping("/add-course/{personId}/{courseId}")
//	public PersonDTO createPersonAndCourse(@RequestBody PersonCreateDTO personCreateDTO) {
//		Person createPerson = personService.createPerson(personMapper.personCreateDTO2Person(personCreateDTO),
//				personCreateDTO.getCourseIds());
//		return personMapper.person2PersonDTO(createPerson);
//	}

	@GetMapping("/list")
	public List<PersonDTO> getAllPersons() {
		return personMapper.personList2PersonListDTO(personService.getAllPersons());
	}

	@GetMapping("/{id}")
	public PersonDTO getPersonById(@PathVariable Integer id) {
		return personMapper.person2PersonDTO(personService.getPersonById(id));
	}

	@DeleteMapping("/{id}")
	public void deletePersonById(@PathVariable Integer id) {
		personService.deletePersonById(id);
	}

	@PutMapping("/{id}")
	public PersonDTO updatePerson(@RequestBody PersonDTO personDTO, @PathVariable Integer id) {
		return personMapper.person2PersonDTO(personService.updatePerson(personMapper.personDTO2Person(personDTO), id));
	}

	@GetMapping("/remove-from-user/{personId}/{carID}")
	public void removeCarFromUser(@PathVariable Integer personId, @PathVariable Integer carId) {
		carService.removeCarFromUser(personId, carId);
	}
	
//	@GetMapping("/remove-course/{personId}/{courseId}")
//	public void removeCourseFromPerson(@PathVariable Integer personId, @PathVariable Integer courseId) {
//		courseService.removeCourseFromPerson(personId, courseId);
//	}

}
