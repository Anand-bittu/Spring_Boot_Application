package com.anand.binding;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PersonDetailes")
public class PersonDetailes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TicketID")
	private Integer ticketID;
	@Column(name = "PassengerName")
	private String passengerName;
	@Column(name = "Form")
	private String form;
	@Column(name = "destination")
	private String to;
	@Column(name = "JouneryDate")
	private Date jouneryDate;

	public PersonDetailes() {
		// TODO Auto-generated constructor stub
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
