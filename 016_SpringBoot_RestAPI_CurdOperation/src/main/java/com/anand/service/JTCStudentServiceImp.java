package com.anand.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anand.binding.JTCStudent;
import com.anand.repo.JTCStudentRepo;

@Service
public class JTCStudentServiceImp implements JTCStudentService{

	@Autowired
	private JTCStudentRepo stdrepo;
	
	
	@Override
	public String upsert(JTCStudent std) {
         stdrepo.save(std);	
		return "success";
	}


	@Override
	public JTCStudent getJTCStudentById(int sid) {
	Optional<JTCStudent> opst=stdrepo.findById(sid);
	  if(opst.isPresent()) {
		  return opst.get();
	  }
		return null;
	}


	@Override
	public List<JTCStudent> getListOfStudent() {
       List<JTCStudent> lresult= stdrepo.findAll();
		return lresult;
	}


	@Override
	public String deleteStudentByID(Integer sid) {
          System.out.println("delete student by sid");
          //delete student
         if(stdrepo.existsById(sid)) {
        	 stdrepo.deleteById(sid);
        	 return "Record is Deleted";
         }else {
        	 return "Record doesnt exits";
        }
	}

	
	
}
