package com.ritesh.springaction.tacocloud.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.springaction.tacocloud.security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
