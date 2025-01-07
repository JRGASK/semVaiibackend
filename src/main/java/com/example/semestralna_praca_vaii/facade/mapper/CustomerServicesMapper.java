package com.example.semestralna_praca_vaii.facade.mapper;

import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesCreteDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesUpdateDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerServicesMapper {

    List<CustomerServicesDto> mapToListCustomerServicesDto(List<CustomerServices> customerServices);

    CustomerServicesDto mapToCustomerServicesDto(CustomerServices customerServices);

    CustomerServices mapToCustomerServices(CustomerServicesCreteDto customerServicesCreteDto);

    CustomerServices mapCustomerServiceUpdateDtoToCustomerService(CustomerServicesUpdateDto customerServicesUpdateDto);

    default PagedModel<CustomerServicesDto> mapToPageDto(Page<CustomerServices> customerServicesPage, Pageable pageable) {
        List<CustomerServicesDto> customerServicesDto = mapToListCustomerServicesDto(customerServicesPage.getContent());
        Page<CustomerServicesDto> customerServicesDtoPage = new PageImpl<>(customerServicesDto, pageable, customerServicesPage.getTotalElements());
        return new PagedModel<CustomerServicesDto>(customerServicesDtoPage);
    }
}
