package com.sunbeaminfo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sunbeaminfo.entities.Customer;
import com.sunbeaminfo.entities.Employee;

public interface CustomerDao extends JpaRepository<Customer, Long> {
////how to get all emps ?  use inherited API : findAll
//	//save emp : save : inherited  method
//	//delete emp details : findById , delete(T entity)
//	//for emp signin : finder method
	Optional<Customer> findByEmailAndPassword(String em,String pass);
//	//Get emp complete names drawing salary > specific salary
//	//custom query approach
////	@Query("select new com.sunbeaminfo.entities.Employee(firstName,lastName) from Employee e where e.salary>:min")
////	List<Employee> fetchEmpNamesBySalary(@Param("min") double minSalary);
//	@Query("select new com.sunbeaminfo.entities.Employee(firstName,lastName) from Employee e where e.salary>?1")
//	List<Employee> xxxxxx(double minSalary);
//	 
}
