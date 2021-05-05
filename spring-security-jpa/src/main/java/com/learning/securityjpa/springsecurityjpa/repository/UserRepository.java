package com.learning.securityjpa.springsecurityjpa.repository;

import com.learning.securityjpa.springsecurityjpa.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {
    Optional<UserModel> findByUserName(String userName);
}
