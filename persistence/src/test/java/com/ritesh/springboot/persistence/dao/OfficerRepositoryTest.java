package com.ritesh.springboot.persistence.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ritesh.springboot.persistence.entities.Officer;

@SpringBootTest
@Transactional
public class OfficerRepositoryTest {

    @Autowired
    OfficerRepository repository;

    @Test
    void testFindAll() {
        List<Officer> officers = repository.findAll();
        assertNotNull(officers);
        assertEquals(5, officers.size());

    }

    @Test
    void testFindById() {
        Optional<Officer> officerOpt = repository.findById(2);
        assertTrue(officerOpt.isPresent());
        assertEquals(2, officerOpt.get().getId());
        assertEquals("Jean-Luc", officerOpt.get().getFirstName());
        assertEquals("Picard", officerOpt.get().getLastName());
    }

    // ? Use @Transactional where we modify DB
    // * In a regular code this commits
    // ! This rollsback when dput over a test
    @Transactional
    @Test
    void testDeleteAll() {
        repository.deleteAll();
        assertEquals(0, repository.count());
    }

    @Test
    void testCount() {
        long count = repository.count();
        assertEquals(5, count);
    }
}
