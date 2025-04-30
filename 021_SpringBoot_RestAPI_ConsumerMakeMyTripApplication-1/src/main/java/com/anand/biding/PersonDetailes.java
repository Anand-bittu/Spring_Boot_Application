package com.anand.biding;

import java.sql.Date;

public class PersonDetailes {

	
	private Integer ticketID;
	
	private String passengerName;
	
	private String form;

	private String to;
	private Date jouneryDate;

	public PersonDetailes() {
		// TODO Auto-generated constructor stub
	}
	public PersonDetailes(Integer ticketID, String passengerName, String form, String to, Date jouneryDate) {
		this.ticketID = ticketID;
		this.passengerName = passengerName;
		this.form = form;
		this.to = to;
		this.jouneryDate = jouneryDate;
	}





	public Integer getTicketID() {
		return ticketID;
	}

	public void setTicketID(Integer ticketID) {
		this.ticketID = ticketID;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getJouneryDate() {
		return jouneryDate;
	}

	public void setJouneryDate(Date jouneryDate) {
		this.jouneryDate = jouneryDate;
	}

	@Override
	public String toString() {
		return "PersonDetailes [ticketID=" + ticketID + ", passengerName=" + passengerName + ", form=" + form + ", to="
				+ to + ", jouneryDate=" + jouneryDate + "]";
	}

	

	
	
	
	
}
