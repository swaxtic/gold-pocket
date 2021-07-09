package com.enigma.challengegoldpocket.repository;

import com.enigma.challengegoldpocket.entity.Pocket;
import com.enigma.challengegoldpocket.model.response.BaseResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PocketRepository extends JpaRepository<Pocket, String> {
}

