package com.sprink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprink.dto.BaseResponse;
import com.sprink.dto.CustomerDTO;
import com.sprink.exception.UserNotFoundException;
import com.sprink.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO req){
		return customerService.createCustomer(req);
	}
	
	@GetMapping(value = "/findById/{id}")
	public ResponseEntity<CustomerDTO> findCustomerById(@PathVariable("id") Long custId) throws UserNotFoundException{
		return customerService.findCustomerById(custId);
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<BaseResponse> userLogin(@RequestBody CustomerDTO dto){
		return customerService.userLogin(dto);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<BaseResponse> handlerAppError(UserNotFoundException e){
		BaseResponse response = new BaseResponse();
		response.setMessage("Failure");
		response.setStatusCode("Server Error: "+e.getMessage());
		return ResponseEntity.internalServerError().body(response);
	}
	
	

}
