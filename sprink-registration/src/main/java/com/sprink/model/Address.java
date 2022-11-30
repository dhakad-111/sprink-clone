package com.sprink.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long id;
	@Column(name = "house_name")
	private String houseName;
	@Column(name = "flat_number")
	private String flatNumber;
	private String landmark;
	private String pincode;
	@OneToOne(mappedBy = "address")
	@JsonIgnore
    private Customer customer;

}
