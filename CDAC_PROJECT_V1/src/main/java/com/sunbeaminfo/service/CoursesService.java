package com.sunbeaminfo.service;

import java.util.List;

import com.sunbeaminfo.dto.ApiResponse;
import com.sunbeaminfo.dto.AuthRequest;
import com.sunbeaminfo.dto.AuthResp;
import com.sunbeaminfo.dto.EmpFullName;
import com.sunbeaminfo.dto.SignupRequest;
import com.sunbeaminfo.dto.SignupResp;
import com.sunbeaminfo.entities.Category;
import com.sunbeaminfo.entities.Courses;
import com.sunbeaminfo.entities.Employee;

public interface CoursesService {
	List<Courses> getAllCourses();
	Courses AddCourseDetails(Courses c);
	public List<Courses> ListOfCoursesByCategory(Category c);
//	Employee addEmpDetails(Employee emp);
//	Employee getEmpDetails(Long empId);
	//ApiResponse deleteEmpDetails(Long empId);
	//add a method for emp signin
//	AuthResp authenticateEmp(AuthRequest request);
	//emp sign up
	//SignupResp signupEmp(SignupRequest request);
	//list all emp names havinf a sal > min sal
//	List<EmpFullName> getEmpNamesBySalarySanket(double minSal);
}
