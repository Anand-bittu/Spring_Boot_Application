package com.anand.exception;

import java.time.LocalDateTime;

public class Excpo {

	private String excode;
	private String exmsg;
	private LocalDateTime ldt;
	public Excpo() {
		// TODO Auto-generated constructor stub
	}
	public String getExcode() {
		return excode;
	}
	public void setExcode(String excode) {
		this.excode = excode;
	}
	public String getExmsg() {
		return exmsg;
	}
	public void setExmsg(String exmsg) {
		this.exmsg = exmsg;
	}
	public LocalDateTime getLdate() {
		return ldt;
	}
	public void setLdate(LocalDateTime ldt) {
		this.ldt = ldt;
	}
	@Override
	public String toString() {
		return "Excpo [excode=" + excode + ", exmsg=" + exmsg + ", ldt=" + ldt + "]";
	}
	
	
}
