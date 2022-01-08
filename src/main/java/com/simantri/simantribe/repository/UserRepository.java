package com.simantri.simantribe.repository;

import com.simantri.simantribe.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    @Query(value="select * from users where username=:username and password=:password", nativeQuery = true)
    Optional<User> getUserByAuth(@Param("username") String username, @Param("password") String password);

}
