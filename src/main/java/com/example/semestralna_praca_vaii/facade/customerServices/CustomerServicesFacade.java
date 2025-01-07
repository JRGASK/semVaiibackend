package com.example.semestralna_praca_vaii.facade.customerServices;

import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesCreteDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesUpdateDto;
import com.example.semestralna_praca_vaii.facade.mapper.CustomerServicesMapper;
import com.example.semestralna_praca_vaii.service.customerServices.CustomerServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class CustomerServicesFacade implements ICustomerServicesFacade{

    private final CustomerServicesMapper customerServicesMapper;

    private final CustomerServicesService customerServicesService;

    @Autowired
    public CustomerServicesFacade(CustomerServicesMapper customerServicesMapper, CustomerServicesService customerServicesService) {
        this.customerServicesMapper = customerServicesMapper;
        this.customerServicesService = customerServicesService;
    }

    @Override
    public PagedModel<CustomerServicesDto> getAllCustomerServices(Pageable pageable) {
        return this.customerServicesMapper.mapToPageDto(this.customerServicesService.getAllCustomerServices(pageable),pageable);
    }

    @Override
    public CustomerServicesDto getCustomerServiceById(Integer id) {
        return this.customerServicesMapper.mapToCustomerServicesDto(this.customerServicesService.getCustomerServicesById(id));
    }

    @Override
    public void deleteCustomerServiceById(Integer id) {
        this.customerServicesService.deleteCustomerServicesById(id);
    }

    @Override
    public CustomerServicesDto addCustomerService(CustomerServicesCreteDto customerServicesCreteDto) {
        CustomerServices customerServices = this.customerServicesMapper.mapToCustomerServices(customerServicesCreteDto);
        return this.customerServicesMapper.mapToCustomerServicesDto(this.customerServicesService.addCustomerServices(customerServices));
    }

    @Override
    public CustomerServicesDto updateCustomerService(Integer id, CustomerServicesUpdateDto customerServicesUpdateDto) {
        CustomerServices customerServices = this.customerServicesMapper.mapCustomerServiceUpdateDtoToCustomerService(customerServicesUpdateDto);
        return this.customerServicesMapper.mapToCustomerServicesDto(this.customerServicesService.updateCustomerServices(id,customerServices));
    }
}
