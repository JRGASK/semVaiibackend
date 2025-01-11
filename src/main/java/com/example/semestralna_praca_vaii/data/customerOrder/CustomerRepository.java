package com.example.semestralna_praca_vaii.data.customerOrder;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository {

    Page<CustomerOrder> findAll();

    Optional<CustomerOrder> findById(Integer id);

    boolean existsById(Integer id);

    @Query("SELECT c FROM CustomerOrder c WHERE c.person.email = :email")
    Page<CustomerOrder> findByEmail(String email);
}
