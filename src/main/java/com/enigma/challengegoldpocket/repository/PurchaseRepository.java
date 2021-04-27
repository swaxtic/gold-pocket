package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase,String> {
}
