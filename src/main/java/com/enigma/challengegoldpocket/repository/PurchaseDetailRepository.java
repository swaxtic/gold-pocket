package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.PurchaseDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseDetailRepository extends JpaRepository<PurchaseDetail,String> {
}
