//package com.application.modul3.course.mapper;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.springframework.stereotype.Component;
//
//import com.application.modul3.course.Course;
//import com.application.modul3.course.dto.CourseCreateDTO;
//import com.application.modul3.course.dto.CourseDTO;
//
//@Component
//public class CourseMapper {
//
//	public CourseDTO course2CourseDTO(Course course) {
//		CourseDTO courseDTO = new CourseDTO();
//		courseDTO.setId(course.getId());
//		courseDTO.setName(course.getName());
//		courseDTO.setCategory(course.getCategory());
//		return courseDTO;
//	}
//
//	public Course courseDTO2Course(CourseDTO courseDTO) {
//		Course course = new Course();
//		course.setId(courseDTO.getId());
//		course.setName(courseDTO.getName());
//		course.setCategory(courseDTO.getCategory());
//		return course;
//	}
//
//	public Course courseCreatDTO2Course(CourseCreateDTO courseCreateDTO) {
//		Course course = new Course();
//		course.setName(courseCreateDTO.getName());
//		course.setCategory(courseCreateDTO.getCategory());
//		return course;
//	}
//
//	public List<CourseDTO> courseList2CourseDTOList(List<Course> courses) {
//		return courses.stream().map(course -> course2CourseDTO(course)).collect(Collectors.toList());
//	}
//
//}
