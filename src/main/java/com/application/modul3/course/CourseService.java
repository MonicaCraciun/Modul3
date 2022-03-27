//package com.application.modul3.course;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.application.modul3.person.Person;
//import com.application.modul3.person.PersonService;
//
//@Service
//public class CourseService {
//
//	@Autowired
//	private CourseRepository courseRepository;
//
//	@Autowired
//	private PersonService personService;
//
//	public Course createCourse(Course course) {
//		return courseRepository.saveAndFlush(course);
//	}
//
//	public List<Course> getAllCourses() {
//		return courseRepository.findAll();
//	}
//
//	public Set<Course> getCourses(Set<Integer> courseIds) {
//		return courseRepository.findByIdIn(courseIds);
//	}
//
//	public Course getCourseById(Integer id) {
//		Optional<Course> courseOpt = courseRepository.findById(id);
//		if (courseOpt.isPresent()) {
//			return courseOpt.get();
//		}
//		return null;
//	}
//
//	public void deleteCourseById(Integer id) {
//		courseRepository.deleteById(id);
//	}
//
//	public Course updateCourseById(Course course, Integer id) {
//		Course courseUpdate = getCourseById(id);
//		courseUpdate.setName(course.getName());
//		courseUpdate.setCategory(course.getCategory());
//		courseRepository.flush();
//		return courseUpdate;
//	}
//
//	public Course getCourseByName(String name) {
//		return courseRepository.findByNameContaining(name);
//	}
//
//	public void removeCourseFromPerson(Integer personId, Integer courseId) {
//		Person person = personService.getPersonById(personId);
//		Course course = getCourseById(courseId);
//		person.removeCourse(course);
//		courseRepository.flush();
//	}
//
//}
