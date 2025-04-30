package com.anand.service;

import java.util.List;

import com.anand.binding.PersonDetailes;

public interface PersonService {

	public String bookTicket(PersonDetailes booking);
	
	public List<PersonDetailes> getPerson();
	
	public PersonDetailes getPersonByID(Integer id);
	
	public String deletePersonBYID(Integer id);
}
