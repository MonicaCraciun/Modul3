package com.application.modul3.person;

import java.util.List;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.application.modul3.course.Course;
//import com.application.modul3.course.CourseService;
import com.application.modul3.exception.ResourceNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

//	@Autowired
//	private CourseService courseService;

//	public Person createPerson(Person person, Set<Integer> courseIds) {
//		Set<Course> courses = courseService.getCourses(courseIds);
//		for (Course course : courses) {
//			person.addCourse(course);
//		}
//		return personRepository.save(person);
//	}

	public Person createPerson(Person person) {
		return personRepository.saveAndFlush(person);
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person getPersonById(Integer id) {
//		Optional<Person> personOpt = personRepository.findById(id);
//		if (personOpt.isPresent()) {
//			return personOpt.get();
//		}
//		return null;
		// nullpointer exception
		return personRepository.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Person not found with id " + id));
	}

	public void deletePersonById(Integer id) {
		personRepository.deleteById(id);
	}

	public Person updatePerson(Person person, Integer id) {
		Person personUpdate = getPersonById(id);
		personUpdate.setLastName(person.getLastName());
		personUpdate.setFirstName(person.getFirstName());
		personUpdate.setAge(person.getAge());
		personRepository.flush();
		return personUpdate;
	}

//	public void removeCourseFromPerson(Integer personId, Integer courseId) {
//		Course course = courseService.getCourseById(courseId);
//		Person person = getPersonById(personId);
//		person.removeCourse(course);
//		personRepository.flush();
//	}

}
