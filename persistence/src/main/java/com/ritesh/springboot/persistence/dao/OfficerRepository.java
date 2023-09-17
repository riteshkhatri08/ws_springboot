
package com.ritesh.springboot.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ritesh.springboot.persistence.entities.Officer;
public interface OfficerRepository extends JpaRepository<Officer, Integer> {

}