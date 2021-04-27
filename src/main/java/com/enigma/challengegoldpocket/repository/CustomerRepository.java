package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    public List<Customer> findAllByFirstNameStartingWithAndEmailContainingAndBirthDateBetween(String firstName, String email, Date startDate, Date endDate, Pageable pageable);
}
