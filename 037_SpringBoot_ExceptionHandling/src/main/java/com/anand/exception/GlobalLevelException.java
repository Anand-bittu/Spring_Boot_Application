package com.anand.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalLevelException {

	
	@ExceptionHandler(value = CoursesNotFoundException.class)
	public ResponseEntity<Excpo> handleCourseException(CoursesNotFoundException cne){
		String msg=cne.getMessage();
		Excpo exinfo=new Excpo();
		exinfo.setExcode("Excourse123");
		exinfo.setExmsg(msg);
		exinfo.setLdate(LocalDateTime.now());
		return new ResponseEntity<Excpo>(exinfo,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = Exception.class)
	   public ResponseEntity<Excpo> handleException(Exception exc){
		   String msg=exc.getMessage();
		   Excpo exinfo=new Excpo();
		   exinfo.setExcode("Except1245");
		   exinfo.setExmsg(msg);
		   exinfo.setLdate(LocalDateTime.now());
		   return new ResponseEntity<Excpo>(exinfo,HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	
	
}
