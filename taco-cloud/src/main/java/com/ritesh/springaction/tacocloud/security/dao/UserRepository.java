package com.ritesh.springaction.tacocloud.security.dao;

import org.springframework.data.repository.CrudRepository;

import com.ritesh.springaction.tacocloud.security.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
