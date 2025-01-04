package com.example.semestralna_praca_vaii.service.vehicle;

import com.example.semestralna_praca_vaii.controller.exception.ResourceAlreadyExists;
import com.example.semestralna_praca_vaii.controller.exception.ResourceNotFound;
import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import com.example.semestralna_praca_vaii.data.vehicle.VehicleRepository;
import com.example.semestralna_praca_vaii.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VehicleService implements IVehicleService{

    private final VehicleRepository vehicleRepository;

    private final PersonService personService;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository, PersonService personService) {
        this.vehicleRepository = vehicleRepository;
        this.personService = personService;
    }

    @Override
    public Page<Vehicle> getAllVehicles(Pageable pageable) {
        return this.vehicleRepository.findAll(pageable);
    }

    @Override
    public Vehicle getVehicleByPlate(String plate) {
        Optional<Vehicle> vehicle = this.vehicleRepository.findByPlateNumber(plate);

        if(vehicle.isEmpty()) {
            throw new ResourceNotFound(String.format("Vehicle with %s does not exists",plate));
        }else {
            return vehicle.get();
        }
    }

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        Person owner = this.personService.getPersonByEmail(vehicle.getEmail());

        if(this.vehicleRepository.existsByPlateNumber(vehicle.getPlateNumber())) {
            throw new ResourceAlreadyExists(String.format("Vehicle with %s already exists",vehicle.getPlateNumber()));
        }else {
            vehicle.setPerson(owner);
            return this.vehicleRepository.save(vehicle);
        }
    }

    @Override
    public Vehicle updateVehicle(String plate, Vehicle vehicleUpdate) {
        Optional<Vehicle> vehicle = this.vehicleRepository.findByPlateNumber(plate);
        if (vehicle.isEmpty()) {
            throw new ResourceNotFound(String.format("Vehicle with %s does not exists",plate));
        }else {
            vehicle.get().setColor(vehicleUpdate.getColor());
            vehicle.get().setEngine(vehicleUpdate.getEngine());
            vehicle.get().setPlateNumber(vehicleUpdate.getPlateNumber());
            vehicle.get().setMake(vehicleUpdate.getMake());
            vehicle.get().setModel(vehicleUpdate.getModel());
            vehicle.get().setType(vehicleUpdate.getType());
            return this.vehicleRepository.save(vehicle.get());
        }
    }

    @Override
    public void deleteVehicleByPlate(String plate) {
        Vehicle vehicle = this.getVehicleByPlate(plate);
        this.vehicleRepository.delete(vehicle);
    }

    @Override
    public Page<Vehicle> getVehiclesByEmail(String email, Pageable pageable) {
        return this.vehicleRepository.findByEmail(email,pageable);
    }
}
