package com.example.semestralna_praca_vaii.facade.vehicle;

import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleUpdateDto;
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
        return this.vehicleMapper.mapToPageDto(this.vehicleService.getAllVehicles(pageable), pageable);
    }

    @Override
    public VehicleDto getVehicleByPlate(String plate) {
        return this.vehicleMapper.mapToVehicleDto(this.vehicleService.getVehicleByPlate(plate));
    }

    @Override
    public void deleteVehicleByPlate(String plate) {
        this.vehicleService.deleteVehicleByPlate(plate);
    }

    @Override
    public VehicleDto addVehicle(VehicleCreateDto vehicleCreateDto) {
        Vehicle vehicle = this.vehicleMapper.mapToVehicle(vehicleCreateDto);
        return this.vehicleMapper.mapToVehicleDto(this.vehicleService.addVehicle(vehicle));
    }

    @Override
    public VehicleDto updateVehicle(String plate, VehicleUpdateDto vehicleUpdateDto) {
        Vehicle vehicle = this.vehicleMapper.vehicleUpdateDtoToVehicle(vehicleUpdateDto);
        return this.vehicleMapper.mapToVehicleDto(this.vehicleService.updateVehicle(plate, vehicle));
    }

    @Override
    public PagedModel<VehicleDto> getVehicleByEmail(String email, Pageable pageable) {
        return this.vehicleMapper.mapToPageDto(this.vehicleService.getVehiclesByEmail(email,pageable),pageable);
    }
}
