package com.example.semestralna_praca_vaii.data.customerOrder;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerOrderRepository {

    Page<CustomerOrder> findAll(Pageable pageable);

    Optional<CustomerOrder> findById(Long id);

    boolean existsById(Integer id);

    @Query("SELECT c FROM CustomerOrder c WHERE c.person.email = :email")
    Page<CustomerOrder> findByEmail(String email, Pageable pageable);
}
