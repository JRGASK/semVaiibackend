package com.example.semestralna_praca_vaii.facade.vehicle;

import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleUpdateDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

public interface IVehicleFacade {

    PagedModel<VehicleDto> getAllVehicles(Pageable pageable);

    VehicleDto getVehicleByPlate(String plate);

    void deleteVehicleByPlate(String plate);

    VehicleDto addVehicle(VehicleCreateDto vehicleCreateDto);

    VehicleDto updateVehicle(String plate, VehicleUpdateDto vehicleUpdateDto);

    PagedModel<VehicleDto> getVehicleByEmail(String email, Pageable pageable);

}
