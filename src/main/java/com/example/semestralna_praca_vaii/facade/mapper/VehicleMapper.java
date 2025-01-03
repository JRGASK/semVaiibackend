package com.example.semestralna_praca_vaii.facade.mapper;

import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleUpdateDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

    List<VehicleDto> mapToListVehicleDto(List<Vehicle> vehicle);

    VehicleDto mapToVehicleDto(Vehicle vehicle);

    Vehicle mapToVehicle(VehicleCreateDto vehicleCreateDto);

    Vehicle vehicleUpdateDtoToVehicle(VehicleUpdateDto vehicleUpdateDto);

    default PagedModel<VehicleDto> mapToPageDto(Page<Vehicle> vehiclePage, Pageable pageable) {
        List<VehicleDto> vehicleDtos = mapToListVehicleDto(vehiclePage.getContent());
        Page<VehicleDto> vehicleDtoPage = new PageImpl<>(vehicleDtos, pageable, vehiclePage.getTotalElements());
        return new PagedModel<VehicleDto>(vehicleDtoPage);
    }
}
