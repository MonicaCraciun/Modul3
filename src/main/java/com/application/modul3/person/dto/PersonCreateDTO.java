package com.application.modul3.person.dto;

import java.util.Set;

public class PersonCreateDTO {

	private String firstName;
	private String lastName;
	private int age;
	//private Set<Integer> courseIds;


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	public Set<Integer> getCourseIds() {
//		return courseIds;
//	}
//	
//	public void setCourseIds(Set<Integer> courseIds) {
//		this.courseIds = courseIds;
//	}
}
