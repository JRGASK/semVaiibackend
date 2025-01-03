package com.example.semestralna_praca_vaii.service.vehicle;

import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IVehicleService {

    Page<Vehicle> getAllVehicles(Pageable pageable);

    Vehicle getVehicleByPlate(String plate);

    Vehicle addVehicle(Vehicle vehicle);

    Vehicle updateVehicle(String plate, Vehicle vehicleUpdate);

    void deleteVehicleByPlate(String plate);

    Page<Vehicle> getVehiclesByEmail(String email, Pageable pageable);


}
