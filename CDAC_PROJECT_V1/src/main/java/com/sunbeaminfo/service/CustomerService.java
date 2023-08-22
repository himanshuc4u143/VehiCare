package com.sunbeaminfo.service;

import java.util.List;

import com.sunbeaminfo.dto.ApiResponse;
import com.sunbeaminfo.dto.AuthRequest;
import com.sunbeaminfo.dto.AuthResp;
import com.sunbeaminfo.dto.SignupRequest;
import com.sunbeaminfo.dto.SignupResp;
import com.sunbeaminfo.entities.Customer;
import com.sunbeaminfo.entities.Orders;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer addCustDetails(Customer Cust);
	Customer getCustDetails(Long CustId);
	ApiResponse deleteCustDetails(Long CustId);
	//add a method for Cust signin
	AuthResp authenticateCust(AuthRequest request);
	//Cust sign up
	SignupResp signupCust(SignupRequest request);
	Boolean AddNewOrder(Long id,Orders o);
	
	
}
