package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PocketRepository extends JpaRepository<Pocket, String> {
}
