package com.sunbeaminfo.service;

import java.util.List;

import com.sunbeaminfo.dto.ApiResponse;
import com.sunbeaminfo.dto.AuthRequest;
import com.sunbeaminfo.dto.AuthResp;
import com.sunbeaminfo.dto.EmpFullName;
import com.sunbeaminfo.dto.SignupRequest;
import com.sunbeaminfo.dto.SignupResp;
import com.sunbeaminfo.entities.Orders;

public interface OrdersService {
	List<Orders> getAllOrderss();
	Orders addOrderDetails(Orders emp);
	Orders getOrderDetails(Long empId);
	ApiResponse deleteOrderDetails(Long Oid);
	
	//list all emp names havinf a sal > min sal
	//List<EmpFullName> getEmpNamesBySalarySanket(double minSal);
}
