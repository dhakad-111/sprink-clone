package com.sprink.service;

import org.springframework.http.ResponseEntity;

import com.sprink.dto.BaseResponse;
import com.sprink.dto.CustomerDTO;
import com.sprink.exception.UserNotFoundException;

public interface CustomerService {

	ResponseEntity<CustomerDTO> findCustomerById(Long custId) throws UserNotFoundException;
	ResponseEntity<CustomerDTO> createCustomer(CustomerDTO req);
	ResponseEntity<BaseResponse> userLogin(CustomerDTO dto);

}
