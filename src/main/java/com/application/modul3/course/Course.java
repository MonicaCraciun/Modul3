//package com.application.modul3.course;
//
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//
//import com.application.modul3.person.Person;
//
//@Entity
//@Table(name = "course", schema = "administration")
//public class Course {
//
//	@Id
//	@Column(name = "id")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//
//	@Column(name = "name")
//	private String name;
//
//	@Column(name = "category")
//	private String category;
//
//	@ManyToMany(mappedBy = "courses")
//	private List<Person> persons;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public List<Person> getPersons() {
//		return persons;
//	}
//
//	public void setPersons(List<Person> persons) {
//		this.persons = persons;
//	}
//
//}
