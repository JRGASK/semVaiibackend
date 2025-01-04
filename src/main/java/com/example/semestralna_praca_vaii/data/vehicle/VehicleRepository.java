package com.example.semestralna_praca_vaii.data.vehicle;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {

    Page<Vehicle> findAll(Pageable pageable);

    Optional<Vehicle> findByPlateNumber(String plateNumber);

    boolean existsByPlateNumber(String plateNumber);

    @Query("SELECT v FROM Vehicle v WHERE v.person.email = :email")
    Page<Vehicle> findByEmail(String email, Pageable pageable);

}
