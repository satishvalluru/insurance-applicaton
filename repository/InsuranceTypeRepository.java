package com.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.model.Insurances;

@Repository
public interface InsuranceTypeRepository extends JpaRepository<Insurances, Integer> {

	List<Insurances> findByInsuranceNameContains(String insuranceName);

}
