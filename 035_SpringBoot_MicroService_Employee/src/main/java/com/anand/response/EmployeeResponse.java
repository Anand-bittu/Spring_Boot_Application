package com.anand.response;



public class EmployeeResponse {

	 
		private Integer eid;
	  
		private String ename;
	
		private Double salary;
		
		private AddressResponse response;
		
		
	public EmployeeResponse() {
		// TODO Auto-generated constructor stub
	}

		public AddressResponse getResponse() {
		return response;
	}

	public void setResponse(AddressResponse response) {
		this.response = response;
	}

		public Integer getEid() {
			return eid;
		}

		public void setEid(Integer eid) {
			this.eid = eid;
		}

		public String getEname() {
			return ename;
		}

		public void setEname(String ename) {
			this.ename = ename;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

	
	
	
}
