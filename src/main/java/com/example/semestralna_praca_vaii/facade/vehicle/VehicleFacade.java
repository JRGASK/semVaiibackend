package com.example.semestralna_praca_vaii.facade.vehicle;

import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleDto;
import com.example.semestralna_praca_vaii.facade.mapper.VehicleMapper;
import com.example.semestralna_praca_vaii.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class VehicleFacade implements IVehicleFacade {

    private final VehicleService vehicleService;

    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleFacade(VehicleService vehicleService, VehicleMapper vehicleMapper) {
        this.vehicleService = vehicleService;
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public PagedModel<VehicleDto> getAllVehicles(Pageable pageable) {
        return null;
    }

    @Override
    public VehicleDto getVehicleByPlate(String plate) {
        return null;
    }

    @Override
    public void deleteVehicleByPlate(String plate) {

    }

    @Override
    public VehicleDto addVehicle(VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public VehicleDto updateVehicle(String plate, VehicleDto vehicleDto) {
        return null;
    }

    @Override
    public PagedModel<VehicleDto> getVehicleByEmail(String email, Pageable pageable) {
        return null;
    }
}
