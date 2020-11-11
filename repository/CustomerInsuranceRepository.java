package com.java.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.model.CustomerPolicy;

@Repository
public interface CustomerInsuranceRepository extends JpaRepository<CustomerPolicy, Integer> {

	List<CustomerPolicy> findByCustomerId(Integer customerId, Pageable pageable);

}
