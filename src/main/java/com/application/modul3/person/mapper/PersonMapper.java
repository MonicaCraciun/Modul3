package com.application.modul3.person.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.modul3.person.Person;
import com.application.modul3.person.dto.PersonCreateDTO;
import com.application.modul3.person.dto.PersonDTO;

@Service
public class PersonMapper {
	
	public PersonDTO person2PersonDTO(Person person) {
		PersonDTO personDTO = new PersonDTO();
		personDTO.setId(person.getId());
		personDTO.setFirstName(person.getFirstName());
		personDTO.setLastName(person.getLastName());
		personDTO.setAge(person.getAge());
		return personDTO;
	}
	
	public Person personDTO2Person(PersonDTO personDTO) {
		Person person = new Person();
		person.setId(personDTO.getId());
		person.setFirstName(personDTO.getFirstName());
		person.setLastName(personDTO.getLastName());
		person.setAge(personDTO.getAge());
		return person;
	}
	
	
	
	public Person personCreateDTO2Person(PersonCreateDTO personCreateDTO) {
		Person person = new Person();
		person.setFirstName(personCreateDTO.getFirstName());
		person.setLastName(personCreateDTO.getLastName());
		person.setAge(personCreateDTO.getAge());
		return person;
	}
	
	public List<PersonDTO> personList2PersonListDTO(List<Person>persons) {
		return persons.stream().map(person -> person2PersonDTO(person)).collect(Collectors.toList());
	}

}
