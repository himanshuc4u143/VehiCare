package com.sunbeaminfo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeaminfo.dto.ApiResponse;
import com.sunbeaminfo.dto.AuthRequest;
import com.sunbeaminfo.dto.SignupRequest;
import com.sunbeaminfo.entities.Orders;
import com.sunbeaminfo.service.CustomerService;
import com.sunbeaminfo.service.OrdersService;

@RestController // mandatory class level anno , consists of =@Controller : cls level
				// +@ResponseBody : ret type of req handling
				// methods(@RequestMapping/@GetMapping...)
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:3000")
public class OrdersController {
	// dep : service layer i.f
	@Autowired
	private OrdersService ordersService;
	
	@Autowired
	private CustomerService customerservice;

	public OrdersController() {
		System.out.println("in ctor of " + getClass());
	}

	// add a method : REST API end point , to get all orderss
	// Req : http://host:port/Orderss , method ; GET
	@GetMapping
	public List<Orders> listAllorderss() {
		return ordersService.getAllOrderss();
	}

	// add a method : REST API end point , to add new orders details
	// Req : http://host:port/Orderss , method ; POST
	@PostMapping("/{CustId}")
	public Orders saveordersDetails(@RequestBody Orders orders,@PathVariable Long CustId)
	// @RequestBody : mandatory method arg level annotation for de-ser / un
	// marshalling
	// => json ---> java
	{
		
		orders.setSelectedCustomer(customerservice.getCustDetails(CustId));
		System.out.println("in save orders " + orders.getId());// id : null (transient)
		return ordersService.addOrderDetails(orders);
	}

	// add a method : REST API end point , to delete orders details
	// Req : http://host:port/Orderss/ordersId , method : DELETE
	@DeleteMapping("/{ordersId}")
	// @PathVariable : method arg level anno , for binding URI torderslate var to req
	// handling method arg.
	public ApiResponse deleteordersDetails(@PathVariable Long ordersId) {
		System.out.println("in del orders " + ordersId);
		return ordersService.deleteOrderDetails(ordersId);
	}

	// add a method : REST API end point , to get orders details by id
	// Req : http://host:port/Orderss/ordersId , method : GET
	@GetMapping("/{id}")
	public Orders getordersDetailsById(@PathVariable Long id) {
		System.out.println("in get orders dtls " + id);
		return ordersService.getOrderDetails(id);
	}
	// add a method : REST API end point , to get orders details by id
	// Req : http://host:port/Orderss/ordersId , method : GET

	@PutMapping
	public Orders updateOrdersDetails(@RequestBody Orders detachedorders) {
		System.out.println("in update orders " + detachedorders.getId());// not null
		// validate
		ordersService.getOrderDetails(detachedorders.getId());
		// => orders exists by the id --> continue to update
		return ordersService.addOrderDetails(detachedorders);
	}

	// add a method : REST API end point , to orders signin
	// Req : http://host:port/Orderss/signin method=POST
	// req payload : req dto
	// resp : resp dto
//	@PostMapping("/signIn")
//	public ResponseEntity<?> authenticateorders(@RequestBody @Valid AuthRequest request) {
//		System.out.println("in sign in " + request);
//
//		return new ResponseEntity<>(ordersService.authenticateorders(request), HttpStatus.OK);
//
//	}

	// add a method to hire / signup new Orders
	// Req : http://host:port/Orderss/signup method=POST
	// req payload : all orders details except id
	// resp : resp dto all orders dtls except password
//	@PostMapping("/signup")
//	public ResponseEntity<?> hireOrders(@RequestBody @Valid SignupRequest request) {
//		System.out.println("in hire orders " + request);
//		// invoke service layer
//		return ResponseEntity.status(HttpStatus.CREATED).body(ordersService.signuporders(request));
//	}

	// add a method list all orders names drawing sal > min sal
	// Req : http://host:port/Orderss/salary/{minSal} , method=GET
	
	
	
//	@GetMapping("/salary/{minSal}")
//	public ResponseEntity<?> listordersNamesBySalary(@PathVariable double minSal) {
//		System.out.println("in list orders names " + minSal);
//		return ResponseEntity.ok(ordersService.getordersNamesBySalarySanket(minSal));
//	}

}
