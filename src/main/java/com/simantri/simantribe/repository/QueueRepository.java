package com.simantri.simantribe.repository;

import com.simantri.simantribe.model.entity.Queue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface QueueRepository extends JpaRepository<Queue, Long>, JpaSpecificationExecutor<Queue> {

    @Query(value="select count (id) from queue where status=:status and locket=:locket and date=:date", nativeQuery = true)
    Integer countByLocket(@Param("status") String status, @Param("locket") String locket, @Param("date")Date date);

    // get all by current date, locket and status is awaiting
    // get detail by id (karena pasti unik)
}
