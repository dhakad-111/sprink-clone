package com.sprink.service.impl;

import java.util.Optional;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprink.dto.BaseResponse;
import com.sprink.dto.CustomerDTO;
import com.sprink.exception.UserNotFoundException;
import com.sprink.model.Customer;
import com.sprink.repository.CustomerRepository;
import com.sprink.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<CustomerDTO> findCustomerById(Long custId) throws UserNotFoundException {
		log.info("findbyId");
		Optional<Customer> optional = customerRepository.findById(custId);
		if (optional.isPresent()) {
			org.dozer.Mapper mapper = new DozerBeanMapper();
			CustomerDTO dto = mapper.map(optional.get(), CustomerDTO.class);
			dto.setMessage("success");
			dto.setStatusCode("200");
			return new ResponseEntity<>(dto, HttpStatus.OK);
		} else {
			throw new UserNotFoundException("User Not Found!");
		}
	}

	@Override
	public ResponseEntity<CustomerDTO> createCustomer(CustomerDTO dto) {
		org.dozer.Mapper mapper = new DozerBeanMapper();
		Customer customer = customerRepository.save(mapper.map(dto, Customer.class));
		return new ResponseEntity<>(mapper.map(customer, CustomerDTO.class), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<BaseResponse> userLogin(CustomerDTO dto) {
		return null;
	}


}
