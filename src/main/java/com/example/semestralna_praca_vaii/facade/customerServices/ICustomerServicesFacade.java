package com.example.semestralna_praca_vaii.facade.customerServices;

import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesCreteDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesUpdateDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

public interface ICustomerServicesFacade {

    PagedModel<CustomerServicesDto> getAllCustomerServices(Pageable pageable);

    CustomerServicesDto getCustomerServiceById(Integer id);

    void deleteCustomerServiceById(Integer id);

    CustomerServicesDto addCustomerService(CustomerServicesCreteDto customerServicesCreteDto);

    CustomerServicesDto updateCustomerService(Integer id, CustomerServicesUpdateDto customerServicesUpdateDto);
}
