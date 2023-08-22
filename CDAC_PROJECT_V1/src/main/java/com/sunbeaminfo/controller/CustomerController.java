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
import com.sunbeaminfo.entities.Customer;
import com.sunbeaminfo.entities.Orders;
import com.sunbeaminfo.service.CustomerService;

@RestController // mandatory class level anno , consists of =@Controller : cls level
				// +@ResponseBody : ret type of req handling
				// methods(@RequestMapping/@GetMapping...)
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController {
	// dep : service layer i.f
	@Autowired
	private CustomerService CustService;

	public CustomerController() {
		System.out.println("in ctor of " + getClass());
	}

	// add a method : REST API end point , to get all Custs
	// Req : http://host:port/Customers , method ; GET
	@GetMapping
	public List<Customer> listAllCusts() {
		return CustService.getAllCustomers();
	}

	// add a method : REST API end point , to add new Cust details
	// Req : http://host:port/Customers , method ; POST
	@PostMapping
	public Customer saveCustDetails(@RequestBody Customer Cust)
	// @RequestBody : mandatory method arg level annotation for de-ser / un
	// marshalling
	// => json ---> java
	{
		System.out.println("in save Cust " + Cust.getId());// id : null (transient)
		return CustService.addCustDetails(Cust);
	}

	// add a method : REST API end point , to delete Cust details
	// Req : http://host:port/Customers/CustId , method : DELETE
	@DeleteMapping("/{CustId}")
	// @PathVariable : method arg level anno , for binding URI tCustlate var to req
	// handling method arg.
	public ApiResponse deleteCustDetails(@PathVariable Long CustId) {
		System.out.println("in del Cust " + CustId);
		return CustService.deleteCustDetails(CustId);
	}

	// add a method : REST API end point , to get Cust details by id
	// Req : http://host:port/Customers/CustId , method : GET
	@GetMapping("/{id}")
	public Customer getCustDetailsById(@PathVariable Long id) {
		System.out.println("in get Cust dtls " + id);
		CustService.getAllCustomers();
		return CustService.getCustDetails(id);
	}
	// add a method : REST API end point , to get Cust details by id
	// Req : http://host:port/Customers/CustId , method : GET

	@PutMapping
	public Customer updateCustDetails(@RequestBody Customer detachedCust) {
		System.out.println("in update Cust " + detachedCust.getId());// not null
		// validate
		CustService.getCustDetails(detachedCust.getId());
		// => Cust exists by the id --> continue to update
		return CustService.addCustDetails(detachedCust);
	}

	// add a method : REST API end point , to Cust signin
	// Req : http://host:port/Customers/signin method=POST
	// req payload : req dto
	// resp : resp dto
	@PostMapping("/signIn")
	public ResponseEntity<?> authenticateCust(@RequestBody @Valid AuthRequest request) {
		System.out.println("in sign in " + request);

		return new ResponseEntity<>(CustService.authenticateCust(request), HttpStatus.OK);

	}

	// add a method to hire / signup new Customer
	// Req : http://host:port/Customers/signup method=POST
	// req payload : all Cust details except id
	// resp : resp dto all Cust dtls except password
	@PostMapping("/signup")
	public ResponseEntity<?> hireCustomer(@RequestBody @Valid SignupRequest request) {
		System.out.println("in hire Cust " + request);
		// invoke service layer
		return ResponseEntity.status(HttpStatus.CREATED).body(CustService.signupCust(request));
	}

	// add a method list all Cust names drawing sal > min sal
	// Req : http://host:port/Customers/salary/{minSal} , method=GET
//	@GetMapping("/salary/{minSal}")
//	public ResponseEntity<?> listCustNamesBySalary(@PathVariable double minSal) {
//		System.out.println("in list Cust names " + minSal);
//		return ResponseEntity.ok(CustService.getCustNamesBySalarySanket(minSal));
//	}
   @PostMapping("/orders/{CustId}")
   public ResponseEntity<?> AddNewOrder(@RequestBody Orders o,@PathVariable Long CustId) {
		//System.out.println("in hire Cust " + );
		// invoke service layer
		return ResponseEntity.status(HttpStatus.CREATED).body(CustService.AddNewOrder(CustId, o));
	}
}
