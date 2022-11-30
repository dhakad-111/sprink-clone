package com.sprink.dto;

import lombok.Data;

@Data
public class PasswordForgetDTO extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email;
}
