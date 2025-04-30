package com.anand.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.diagnostics.FailureAnalysisReporter;
import org.springframework.stereotype.Service;

import com.anand.entity.College;
import com.anand.entity.Student;
import com.anand.repo.CollegeRepo;
import com.anand.repo.StudentRepo;

@Service
public class CollegeService {
     @Autowired
	private CollegeRepo crg;
     @Autowired
	private StudentRepo srepo;
	
     public  void addStudents() {
			/*
			 * System.out.println("----------------------------------");
			 * 
			 * //create a College Object College cg1=new College(); cg1.setCname("JNTU");
			 * cg1.setEmail("Jntu@gmail.com");
			 * 
			 * //create Students Object Student s1=new Student(); s1.setSname("Anand");
			 * s1.setEmail("Anand@gmail.com"); Student s2=new Student();
			 * s1.setSname("Rani"); s2.setEmail("Rani@gmail.com"); Student s3=new Student();
			 * s3.setSname("Vani"); s3.setEmail("vani@gmail.com"); // set JNTU Students;
			 * List<Student> ls=Arrays.asList(s1,s2,s3); //save JNTU to the Students
			 * cg1.setStudent(ls); //now set college to Students s1.setCollege(cg1);
			 * s2.setCollege(cg1); s3.setCollege(cg1); //save only Parent which is College
			 * crg.save(cg1);
			 * 
			 * System.out.println("----------------------------");
			 */
    	       System.out.println("-----------------");
    	       College cg2=new College();
    	       cg2.setCname("OU"); cg2.setCname("OU@gmail.com");
    	       Student s4=new Student();
    	       s4.setSname("Hari");s4.setEmail("Hari@gmail.com");
    	       Student s5=new Student();
    	       s5.setSname("Santhosh"); s5.setEmail("santhosh@gmail.com");
    	       //set the student to college
    	       List<Student> li2=Arrays.asList(s4,s5);
    	       //now add student to the college
    	       cg2.setStudent(li2);
    	       //now add college to the Student
    	       s4.setCollege(cg2); s5.setCollege(cg2);
    	       //now only save College Object
    	       crg.save(cg2);
    	       System.out.println("--------------"); 
     }
	
	// method to Retrive the data from the data base 
     public void retriveStudent(Integer id) {
      Optional<College> op=   crg.findById(id);
          if(op.isPresent()) {
    	     System.out.println(op.get());
         }
          else {
        	  System.out.println("college don't exist");
          }
     }
     
     
	
	
}
