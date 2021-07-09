package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>, JpaSpecificationExecutor<Customer> {
    public List<Customer> findAllByFirstNameStartingWithAndEmailContainingAndBirthDateBetween(String firstName, String email, Date startDate, Date endDate, Pageable pageable);

    @Query(value="select * from m_customers where email=:email and password=:password", nativeQuery = true)
    Optional<Customer> getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    // @Query
    //JPQL pakai ENTITY
    @Query("SELECT c FROM Customer c WHERE c.status=:status")
    List<Customer> findActiveCustomer(Integer status);

    //NATIVE SQL
    @Query(value = "SELECT * FROM m_customers "
            ,nativeQuery = true)
    List<Customer> findActiveCustomerNative();
}
