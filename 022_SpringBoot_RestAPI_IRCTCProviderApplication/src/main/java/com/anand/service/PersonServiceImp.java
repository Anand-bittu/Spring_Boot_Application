package com.anand.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.binding.PersonDetailes;
import com.anand.repo.PersonRepo;

@Service
public class PersonServiceImp implements PersonService {

	@Autowired
	private PersonRepo prepo;
	
	//book Ticket Method 
	@Override
	public String bookTicket(PersonDetailes booking) {
		System.out.println("inside service Booking");
       PersonDetailes deatiles=prepo.save(booking);
       System.out.println(deatiles);
		return "Ticket is Booked";
	}

	//get Person Method
	@Override
	public List<PersonDetailes> getPerson() {
       System.out.println("inside Get Person Method in Provider Application");
          //find all by detail
       List<PersonDetailes> lp=prepo.findAll();
       return lp;
	}

	//get Person ByID
	@Override
	public PersonDetailes getPersonByID(Integer id) {
     PersonDetailes pd=prepo.findById(id)
          .orElseThrow(()->new RuntimeException("By This Ticket ID No Person Exists"));
		return pd;
	}

	@Override
	public String deletePersonBYID(Integer id) {
          PersonDetailes pd=prepo.findById(id)
        		  .orElseThrow(()->new RuntimeException("By this Ticket ID No person Exists"));
		if(pd!=null) {
			prepo.deleteById(id);
			return "Ticket with TicketID::"+id+" has Been deleted.....";
		}
		return null;
	}

	
}
