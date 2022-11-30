package com.sprink.service;

import org.springframework.http.ResponseEntity;

import com.sprink.dto.PasswordForgetDTO;

public interface PasswordResetTokenService {

	ResponseEntity<PasswordForgetDTO> forgatePassowrd(PasswordForgetDTO dto);
	ResponseEntity<PasswordForgetDTO> updatePassword(PasswordForgetDTO dto);
}
