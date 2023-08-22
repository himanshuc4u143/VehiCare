package com.sunbeaminfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeaminfo.custom_exceptions.ResourceNotFoundException;
import com.sunbeaminfo.dao.OrdersDao;
import com.sunbeaminfo.dto.ApiResponse;
import com.sunbeaminfo.dto.AuthRequest;
import com.sunbeaminfo.dto.AuthResp;
import com.sunbeaminfo.dto.SignupRequest;
import com.sunbeaminfo.dto.SignupResp;
import com.sunbeaminfo.entities.Employee;
import com.sunbeaminfo.entities.Orders;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
	// dep : orders dao i/f
	@Autowired
	private OrdersDao ordersDao;
	// autowire : model mapper
	@Autowired
	private ModelMapper mapper;

	//For Admin
	@Override
	public List<Orders> getAllOrderss() {
		// TODO Auto-generated method stub
		return ordersDao.findAll();
	}

	//For ALL
	@Override
	public Orders addOrderDetails(Orders orders) {
		// API of CrudRepository : T save(T entity)
		return ordersDao.save(orders);
	}// auto dirty chking --> insert --> sesison closed --> rets detached orders to the
		// caller
  
	
	
	//For Admin
	@Override
	public Orders getOrderDetails(Long ordersId) {
		// TODO Auto-generated method stub
		return ordersDao.findById(ordersId).orElseThrow(() -> new ResourceNotFoundException("orders id invalid !!!!!"));
	}

	@Override
	public ApiResponse deleteOrderDetails(Long Oid) {
		Orders o = getOrderDetails(Oid);
		// => emp id valid
		ordersDao.delete(o); // OR empDao.deleteById(empId)
		return new ApiResponse("Order details deleted !");
	}

	
	

	
	

}
