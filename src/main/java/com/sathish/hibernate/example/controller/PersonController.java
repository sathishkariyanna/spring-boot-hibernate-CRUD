package com.sathish.hibernate.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sathish.hibernate.example.dao.PersonDAO;
import com.sathish.hibernate.example.entity.Person;

/**
 * 
 * @author Sathish
 *
 */
@RestController
@RequestMapping(value = "/person")
public class PersonController {
	@Autowired
	private PersonDAO personDao;

	// Method 1 : using @PathVariable
	// http://localhost:8080/person/save/Kariyanna/Irving/TX
	// we can use @PostMapping instead of (@RequestMapping + method =
	// RequestMethod.POST)
	@RequestMapping(value = "/save/{name}/{city}/{state}", method = RequestMethod.POST)
	public String create(@PathVariable("name") String name, @PathVariable("city") String city,
			@PathVariable("state") String state) {
		try {
			Person person = new Person();
			person.setName(name);
			person.setCity(city);
			person.setState(state);
			personDao.savePerson(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully saved!";
	}

	// Method 2 : using @RequestParam
	// http://localhost:8080/person/save1?name=Sathish1&city=Irving&state=TX
	@RequestMapping(value = "/save1/name/city/state", method = RequestMethod.POST)
	public String create1(@RequestParam("name") String name, @RequestParam("city") String city,
			@RequestParam("state") String state) {
		try {
			Person person = new Person();
			person.setName(name);
			person.setCity(city);
			person.setState(state);
			personDao.savePerson(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully saved!";
	}

	// Method 3 : directly using as in the request URL
	// http://localhost:8080/person/save2?name=Sathish2&city=Irving&state=TX
	@RequestMapping(value = "/save2", method = RequestMethod.POST)
	public String create2(String name, String city, String state) {
		try {
			Person person = new Person();
			person.setName(name);
			person.setCity(city);
			person.setState(state);
			personDao.savePerson(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully saved!";
	}

	// http://localhost:8080/person/allPersons
	@RequestMapping(value = "/allPersons", method = RequestMethod.GET)
	public List<Person> getAllPersons() {
		try {
			return personDao.getAllPersons();
		} catch (Exception ex) {
			return null;
		}
	}

	// http://localhost:8080/person/delete/1
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") long id) {
		try {
			Person person = new Person();
			person.setId(id);
			personDao.delete(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully deleted!";
	}

	// http://localhost:8080/person/update/2/Kariyanna2/Irving/TX
	@RequestMapping(value = "/update/{id}/{name}/{city}/{state}", method = RequestMethod.PUT)
	public String update(@PathVariable("id") long id, @PathVariable("name") String name,
			@PathVariable("city") String city, @PathVariable("state") String state) {
		try {
			Person person = new Person();
			person.setId(id);
			person.setName(name);
			person.setCity(city);
			person.setState(state);
			personDao.updatePerson(person);
		} catch (Exception ex) {
			return ex.getMessage();
		}
		return "Person succesfully updated!";
	}
}
