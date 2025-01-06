package com.example.semestralna_praca_vaii.data.customerServices;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerServicesRepository extends JpaRepository<CustomerServices,Integer> {

    Page<CustomerServices> findAll(Pageable pageable);

    Optional<CustomerServices> findById(Integer id);

    Optional<CustomerServices> findByName(String name);

    boolean existsById(Integer id);

}
