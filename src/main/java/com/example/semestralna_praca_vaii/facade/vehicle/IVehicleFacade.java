package com.example.semestralna_praca_vaii.facade.vehicle;

import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

public interface IVehicleFacade {

    PagedModel<VehicleDto> getAllVehicles(Pageable pageable);

    VehicleDto getVehicleByPlate(String plate);

    void deleteVehicleByPlate(String plate);

    VehicleDto addVehicle(VehicleDto vehicleDto);

    VehicleDto updateVehicle(String plate, VehicleDto vehicleDto);

    PagedModel<VehicleDto> getVehicleByEmail(String email, Pageable pageable);

}
