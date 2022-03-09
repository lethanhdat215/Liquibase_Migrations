package com.example.liquibase_migrations.repository;

import com.example.liquibase_migrations.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {


    @Query("SELECT name FROM Person p WHERE p.name LIKE %:personName%")
    String findByName(String personName);
}
