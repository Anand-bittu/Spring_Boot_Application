package com.anand.service;

import java.util.List;

import com.anand.binding.JTCStudent;

public interface JTCStudentService {

	
	public String upsert(JTCStudent std);
	
	public JTCStudent getJTCStudentById(int sid);
	
	
	public List<JTCStudent> getListOfStudent();
	
	public String deleteStudentByID(Integer sid);
	
	
}
