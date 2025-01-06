package com.example.semestralna_praca_vaii.service.customerServices;

import com.example.semestralna_praca_vaii.controller.exception.ResourceNotFound;
import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import com.example.semestralna_praca_vaii.data.customerServices.CustomerServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServicesService implements ICustomerServices {

    private final CustomerServicesRepository customerServicesRepository;

    @Autowired
    public CustomerServicesService(CustomerServicesRepository customerServicesRepository) {
        this.customerServicesRepository = customerServicesRepository;
    }

    @Override
    public Page<CustomerServices> getAllCustomerServices(Pageable pageable) {
        return this.customerServicesRepository.findAll(pageable);
    }

    @Override
    public CustomerServices getCustomerServicesById(Integer id) {
        Optional<CustomerServices> customerServices = this.customerServicesRepository.findById(id);

        if(customerServices.isEmpty()) {
            throw new ResourceNotFound(String.format("CustomerServices with %s does not exists",id));
        }else {
            return customerServices.get();
        }
    }

    @Override
    public CustomerServices getCustomerServicesByName(String name) {
        Optional<CustomerServices> services = this.customerServicesRepository.findByName(name);

        if(services.isEmpty()) {
            throw new ResourceNotFound(String.format("CustomerServices with %s does not exists",name));
        }else {
           return services.get();
        }
    }

    @Override
    public void deleteCustomerServicesById(Integer id) {
        this.customerServicesRepository.deleteById(id);
    }

    @Override
    public CustomerServices addCustomerServices(CustomerServices customerServices) {
        return this.customerServicesRepository.save(customerServices);
    }

    @Override
    public CustomerServices updateCustomerServices(Integer id, CustomerServices customerServices) {
       Optional<CustomerServices> customerServicesUpdate = this.customerServicesRepository.findById(id);
        if (customerServicesUpdate.isEmpty()){
            throw new ResourceNotFound(String.format("CustomerServices with %s does not exists",id));
        }else {
            customerServicesUpdate.get().setName(customerServices.getName());
            customerServicesUpdate.get().setPrice(customerServices.getPrice());
            customerServicesUpdate.get().setInfo(customerServices.getInfo());
            return this.customerServicesRepository.save(customerServicesUpdate.get());
        }
    }
}
