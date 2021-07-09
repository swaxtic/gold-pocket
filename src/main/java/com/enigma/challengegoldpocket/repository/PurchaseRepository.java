package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.Customer;
import com.enigma.challengegoldpocket.entity.Purchase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,String> {

    @Query(value="SELECT * FROM t_purchases WHERE customer_id=:customerId ORDER BY purchase_date DESC", nativeQuery = true)
    List<Purchase> getPurchasesByCustomerId(@Param("customerId") String customerId);

}
