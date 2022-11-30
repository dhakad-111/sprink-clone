package com.sprink.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "password_reset_token")
@Data
public class PasswordResetToken implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pass_id")
	private Long id;
	private String token;
	@OneToOne(targetEntity = Customer.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	@Column(name = "experation_date")
	private LocalDateTime expirationDate;

}
