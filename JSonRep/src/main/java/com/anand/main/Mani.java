package com.anand.main;

import java.io.File;

import com.anand.customer.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mani {
	
	
	public void ConvertJsonToObject()throws Exception {
		File f=new File("customer.json");
		
		//deSerilization
		ObjectMapper mapper=new ObjectMapper();
		Customer custObject=mapper.readValue(f,Customer.class);
		System.out.println("Deserilization::"+custObject);
		
		
		
	}
     //serlization
	public void ConvertObjectToJson()throws Exception {
		File f=new File("customer.json");
		Customer ct=new Customer();
		ct.setId(1); ct.setName("Anand"); ct.setEmail("a@gmail.com");
		ct.setNumber(45876);
		ObjectMapper mapper=new ObjectMapper();
		//serlization
		mapper.writeValue(f,ct);
		System.out.println("serlization is done");	
	}
	public static void main(String[] args)throws Exception {
		Mani mi=new Mani();
	//	mi.ConvertObjectToJson();
		mi.ConvertJsonToObject();
	}
}
