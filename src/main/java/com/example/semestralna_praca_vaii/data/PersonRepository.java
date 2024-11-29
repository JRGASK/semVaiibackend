package com.example.semestralna_praca_vaii.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {

    Page<Person> findAll(Pageable pageable);

    Optional<Person> findByEmail(String email);

    boolean existsByEmail(String email);
}
