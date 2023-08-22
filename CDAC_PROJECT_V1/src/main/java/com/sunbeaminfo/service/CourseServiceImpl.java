//package com.sunbeaminfo.service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.sunbeaminfo.dao.CourseDao;
//import com.sunbeaminfo.dao.EmployeeDao;
//import com.sunbeaminfo.dto.EmpFullName;
//import com.sunbeaminfo.entities.Course;
//import com.sunbeaminfo.entities.Employee;
//@Service
//@Transactional
//public class CourseServiceImpl implements CourseService{
//
//	
//	@Autowired
//	private CourseDao courseDao;
//	// autowire : model mapper
//	@Autowired
//	private ModelMapper mapper;
//	
//	
//	@Override
//	public List<Course> FindCourseByName(String name) {
//		// TODO Auto-generated method stub
//		  Optional<Course> l= courseDao.findByName(name);
//	//	 List<Course> list=new ArrayList<>();
//	
//
//		  
//		  return l.stream(). //Stream<Emp>
//				map(crs -> mapper.map(crs, Course.class)). //Stream<EmpFullName>
//					collect(Collectors.toList());//List<DTO>
//		  
//	}
//
//}
