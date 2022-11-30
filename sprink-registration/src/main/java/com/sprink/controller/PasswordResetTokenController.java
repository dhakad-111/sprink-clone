package com.sprink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprink.dto.PasswordForgetDTO;
import com.sprink.service.PasswordResetTokenService;

@RestController
@RequestMapping(value = "/users")
public class PasswordResetTokenController {

	@Autowired
	private PasswordResetTokenService passwordResetTokenService;
	
	@PostMapping(value = "/forget-password", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PasswordForgetDTO> forgatePassowrd(@RequestBody PasswordForgetDTO dto){
		return passwordResetTokenService.forgatePassowrd(dto);
	}
	
	@PostMapping(value = "/update-password", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PasswordForgetDTO> updatePassoword(@RequestBody PasswordForgetDTO dto){
		return passwordResetTokenService.updatePassword(dto);
	}
}
