//package com.sunbeaminfo.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.sunbeaminfo.service.CourseService;
//import com.sunbeaminfo.service.CoursesService;
//
//@RestController // mandatory class level anno , consists of =@Controller : cls level
//// +@ResponseBody : ret type of req handling
//// methods(@RequestMapping/@GetMapping...)
//@RequestMapping("/courses")
//@CrossOrigin(origins = "*")
//public class CourseController {
//
//  @Autowired
//  CoursesService courseService;
//
//  public CourseController()
//  {
//	  System.out.println("in course ctr"+this.getClass());
//  }
//	@GetMapping("/crs/{courseName}")
//  public  ResponseEntity<?> listCourseByName(@PathVariable String courseName)
//  {
//		System.out.println("in listby course method");
//		return ResponseEntity.ok(courseService.FindCourseByName(courseName));
//  }
//  
//}
