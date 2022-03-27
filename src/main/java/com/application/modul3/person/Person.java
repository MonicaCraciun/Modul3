package com.application.modul3.person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.modul3.car.Car;
//import com.application.modul3.course.Course;

@Entity
@Table(name = "person", schema = "administration")
public class Person {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "age")
	private int age;

	// orphanRemoval = true, sterge cu totul masina din Db
	// false, doar pune FK pe null in tabela masina
	@OneToMany(mappedBy = "person", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, orphanRemoval = false)
	private Set<Car> cars;

//	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "person_course", schema = "administration", joinColumns = @JoinColumn(name = "person_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "course_id", nullable = false))
//	private List<Course> courses = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String prenume) {
		this.firstName = prenume;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String nume) {
		this.lastName = nume;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addCar(Car car) {
		this.cars.add(car);
		car.setPerson(this);
	}

	public void removeCar(Car car) {
		this.cars.remove(car);
		car.setPerson(null);
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

//	public List<Course> getCourses() {
//		return courses;
//	}
//
//	public void setCourses(List<Course> courses) {
//		this.courses = courses;
//	}
//
//	public void addCourse(Course course) {
//		this.courses.add(course);
//		course.getPersons().add(this);
//	}
//	
//	public void removeCourse(Course course) {
//		this.courses.remove(course);
//		course.setPersons(null);
//	}

}
