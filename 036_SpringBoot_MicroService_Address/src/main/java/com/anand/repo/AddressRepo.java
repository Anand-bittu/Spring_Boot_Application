package com.anand.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.anand.entity.Address;

public interface AddressRepo extends
JpaRepository<Address,Integer> {

	@Query(nativeQuery = true,value ="select ea.aid,ea.city,ea.state,ea.type from address ea join employee e on e.eid where ea.emp_id=:emp_id")
	public Address findAddressByEmpID(
			@Param("emp_id") Integer emp_id);
	
}
