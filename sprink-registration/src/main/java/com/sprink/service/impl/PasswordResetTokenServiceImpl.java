package com.sprink.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sprink.dto.PasswordForgetDTO;
import com.sprink.model.Customer;
import com.sprink.repository.CustomerRepository;
import com.sprink.repository.PasswordResetTokenRepository;
import com.sprink.service.PasswordResetTokenService;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService {

	private static final Logger log = LoggerFactory.getLogger(PasswordResetTokenServiceImpl.class);

	@Autowired
	private PasswordResetTokenRepository passwordResetTokenRepository;
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public ResponseEntity<PasswordForgetDTO> forgatePassowrd(PasswordForgetDTO dto) {
		try {
			Customer customer = customerRepository.findByEmail(dto.getEmail());
			System.out.println("customer :"+customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseEntity<PasswordForgetDTO> updatePassword(PasswordForgetDTO dto) {
		return null;
	}

}
