package com.example.semestralna_praca_vaii.service.customerServices;

import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerServices {

    Page<CustomerServices> getAllCustomerServices(Pageable pageable);

    CustomerServices getCustomerServicesById(Integer id);

    CustomerServices getCustomerServicesByName(String name);

    void deleteCustomerServicesById(Integer id);

    CustomerServices addCustomerServices(CustomerServices customerServices);

    CustomerServices updateCustomerServices(Integer id, CustomerServices customerServices);
}
