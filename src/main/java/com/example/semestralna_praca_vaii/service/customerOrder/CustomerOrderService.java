package com.example.semestralna_praca_vaii.service.customerOrder;


import com.example.semestralna_praca_vaii.controller.exception.ResourceNotFound;
import com.example.semestralna_praca_vaii.data.customerOrder.CustomerOrder;
import com.example.semestralna_praca_vaii.data.customerOrder.CustomerOrderRepository;
import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.data.vehicle.Vehicle;
import com.example.semestralna_praca_vaii.service.customerServices.CustomerServicesService;
import com.example.semestralna_praca_vaii.service.person.PersonService;
import com.example.semestralna_praca_vaii.service.vehicle.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerOrderService implements ICustomerOrderService {

    private final CustomerOrderRepository customerOrderRepository;

    private final PersonService personService;

    private final VehicleService vehicleService;

    private final CustomerServicesService customerServicesService;

    @Autowired
    public CustomerOrderService(CustomerOrderRepository customerOrderRepository, PersonService personService, VehicleService vehicleService, CustomerServicesService customerServicesService) {
        this.customerOrderRepository = customerOrderRepository;
        this.personService = personService;
        this.vehicleService = vehicleService;
        this.customerServicesService = customerServicesService;
    }

    @Override
    public Page<CustomerOrder> getAllCustomerOrders(Pageable pageable) {
        return this.customerOrderRepository.findAll(pageable);
    }

    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        Optional<CustomerOrder> customerOrder = this.customerOrderRepository.findById(id);

        if(customerOrder.isEmpty()) {
            throw new ResourceNotFound(String.format("CustomerOrder with %s does not exists",id));
        }
        return customerOrder.get();
    }

    @Override
    public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
        Person person = this.personService.getPersonByEmail(customerOrder.getEmail());
        Vehicle vehicle = this.vehicleService.getVehicleByPlate(customerOrder.getVehiclePlateNumber());
        CustomerServices customerServices = this.customerServicesService.getCustomerServicesById(customerOrder.getServiceId());
        CustomerOrder order = customerOrder;
        if (this.customerOrderRepository.existsById(customerOrder.getId())) {
            throw new ResourceNotFound(String.format("CustomerOrder with %s already exists",customerOrder.getId()));
        }else {
            customerOrder.setPerson(person);
            customerOrder.setVehicle(vehicle);
            customerOrder.setService(customerServices);
            return this.customerOrderRepository.save(customerOrder);
        }

    }

    @Override
    public CustomerOrder updateCustomerOrder(Long id, CustomerOrder customerOrder) {
        return null;
    }

    @Override
    public void deleteCustomerOrderById(Long id) {
        CustomerOrder customerOrder = this.getCustomerOrderById(id);
        this.customerOrderRepository.delete(customerOrder);
    }

    @Override
    public Page<CustomerOrder> getCustomerOrdersByEmail(String email, Pageable pageable) {
        return this.customerOrderRepository.findByEmail(email,pageable);
    }
}
