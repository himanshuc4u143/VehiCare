package com.sunbeaminfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sunbeaminfo.custom_exceptions.ResourceNotFoundException;
import com.sunbeaminfo.dao.CustomerDao;
import com.sunbeaminfo.dto.ApiResponse;
import com.sunbeaminfo.dto.AuthRequest;
import com.sunbeaminfo.dto.AuthResp;
import com.sunbeaminfo.dto.CustFullName;
import com.sunbeaminfo.dto.SignupRequest;
import com.sunbeaminfo.dto.SignupResp;
import com.sunbeaminfo.entities.Customer;
import com.sunbeaminfo.entities.Orders;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	// dep : Cust dao i/f
	@Autowired
	private CustomerDao CustDao;
	// autowire : model mapper
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		
		return CustDao.findAll();
	}
	

	public CustomerServiceImpl() {
		//
	}


	@Override
	public Customer addCustDetails(Customer Cust) {
		// API of CrudRepository : T save(T entity)
		return CustDao.save(Cust);
	}// auto dirty chking --> insert --> sesison closed --> rets detached Cust to the
		// caller

	@Override
	public Customer getCustDetails(Long CustId) {
		// TODO Auto-generated method stub
		return CustDao.findById(CustId).orElseThrow(() -> new ResourceNotFoundException("Cust id invalid !!!!!"));
	}

	@Override
	public ApiResponse deleteCustDetails(Long CustId) {
		Customer Cust = getCustDetails(CustId);
		// => Cust id valid
		CustDao.delete(Cust); // OR CustDao.deleteById(CustId)
		return new ApiResponse("Cust details deleted !");
	}

	@Override
	public AuthResp authenticateCust(AuthRequest request) {
		// autheticate Cust
		Customer Cust = CustDao.findByEmailAndPassword(request.getEmail(), request.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email or Password !!!!!"));
		// => valid login --> map Entity --> DTO
		// ModelMapper API : public T map(Object src , Class<T> class)
		return mapper.map(Cust, AuthResp.class);
	}

	@Override
	public SignupResp signupCust(SignupRequest request) {
		// map dto --> entity
		Customer Customer = mapper.map(request, Customer.class);
		// invoke dao's method for saving Cust dtls in DB
		Customer Customer2 = CustDao.save(Customer);
		// map entity --> dto
		return mapper.map(Customer2, SignupResp.class);
	}


	@Override
	public Boolean AddNewOrder(Long id,Orders o) {
		 Optional<Customer> c=CustDao.findById(id);
		 boolean d = c.get().getOlist().add(o);
		 return d;
		
	}

//	@Override
//	public List<CustFullName> getCustNamesBySalarySanket(double minSal) {
//		// call dao's method
//		List<Customer> CustList = CustDao.xxxxxx(minSal);
//		List<CustFullName> efn=new ArrayList<>();
//		
//		for(Customer e:CustList)
//		 efn.add(mapper.map(e,CustFullName.class));
//	     return efn;     
////		return CustList.stream(). //Stream<Cust>
////				map(Cust -> mapper.map(Cust, CustFullName.class)). //Stream<CustFullName>
////				collect(Collectors.toList());//List<DTO>
//	}

}
