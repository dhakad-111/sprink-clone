package com.sprink.dto;

import lombok.Data;

@Data
public class CustomerDTO extends BaseResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	private String mobileNumber;
	private String password;
	private AddressDTO address;

}
