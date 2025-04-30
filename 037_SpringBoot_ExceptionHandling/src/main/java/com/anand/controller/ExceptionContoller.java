package com.anand.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anand.exception.CoursesNotFoundException;
import com.anand.exception.Excpo;

@RestController
public class ExceptionContoller {

	   @GetMapping("/greating")
	   public ResponseEntity<String> greatingMsg(){
		   return new ResponseEntity<String>("GoodEvening",HttpStatus.OK);
	   }
	   @GetMapping("/welcome")
	   public ResponseEntity<String> welcomeMsg(){
		   String value="Welcome To Anand";
		   int a=10/0;
		   return new ResponseEntity<String>(value,HttpStatus.OK);
	   }
	   
	   @GetMapping("/getc")
	   public ResponseEntity<String> getCourses(@RequestParam("name")
	   String name){
		   
		   if(name.equals("sbm")) {
			   String c="SBM Course will be started";
			   return new ResponseEntity<String>(c,HttpStatus.OK);
		   }else if(name.equals("jrtp")) {
			   String value="Java Real Time Tools batch start soon";
			   return new ResponseEntity<String>(value,HttpStatus.OK);
		   }else {
		    throw new CoursesNotFoundException("This course Does not Exist.....");
		   }
	   }
	   
	   
	   
	   
	   
	   
	   
		/*
		 * @ExceptionHandler(value = Exception.class) public ResponseEntity<Excpo>
		 * handleException(Exception exc){ String msg=exc.getMessage(); Excpo exinfo=new
		 * Excpo(); exinfo.setExcode("Except1245"); exinfo.setExmsg(msg);
		 * exinfo.setLdate(LocalDateTime.now()); return new
		 * ResponseEntity<Excpo>(exinfo,HttpStatus.INTERNAL_SERVER_ERROR); }
		 */
	   
	   
}
