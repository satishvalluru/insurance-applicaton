package com.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.model.InsuranceCompanies;

@Repository
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompanies, Integer> {

	/*
	 * List<UserOrders> findById(int userId);
	 * 
	 * List<UserOrders> findByUserId(int userId);
	 */

}
