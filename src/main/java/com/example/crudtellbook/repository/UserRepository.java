package com.example.crudtellbook.repository;

import com.example.crudtellbook.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByPhoneNumber(String phoneNumber);
    Optional<UserEntity> deleteByPhoneNumber(String phoneNumber);
}