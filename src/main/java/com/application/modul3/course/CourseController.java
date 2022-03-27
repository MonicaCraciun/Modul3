//package com.application.modul3.course;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/courses")
//public class CourseController {
//
//	@Autowired
//	private CourseService courseService;
//
//	@PostMapping
//	public Course createCourse(@RequestBody Course course) {
//		return courseService.createCourse(course);
//	}
//
//	@GetMapping("/list")
//	public List<Course> getAllCourses() {
//		return courseService.getAllCourses();
//	}
//
//	@GetMapping("/{id}")
//	public Course getCourseById(@PathVariable Integer id) {
//		return courseService.getCourseById(id);
//	}
//
//	@PutMapping("/{id}")
//	public Course updateCourse(@RequestBody Course course, @PathVariable Integer id) {
//		return courseService.updateCourseById(course, id);
//	}
//
//	@DeleteMapping("/{id}")
//	public void deleteCourseById(@PathVariable Integer id) {
//		courseService.deleteCourseById(id);
//	}
//
//	@GetMapping("/{name}")
//	public Course getCourseByName(@RequestParam String name) {
//		return courseService.getCourseByName(name);
//	}
//
//}
