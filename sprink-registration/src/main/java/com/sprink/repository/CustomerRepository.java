package com.sprink.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sprink.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query(value = "SELECT *FROM Customer c where c.email LIKE %?1")
	Customer findByEmail(String email);

}
