package com.example.semestralna_praca_vaii.service.customerOrder;

import com.example.semestralna_praca_vaii.data.customerOrder.CustomerOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerOrderService {

    Page<CustomerOrder>  getAllCustomerOrders(Pageable pageable);

    CustomerOrder getCustomerOrderById(Long id);

    CustomerOrder addCustomerOrder(CustomerOrder customerOrder);

    CustomerOrder updateCustomerOrder(Long id, CustomerOrder customerOrder);

    void deleteCustomerOrderById(Long id);

    Page<CustomerOrder> getCustomerOrdersByEmail(String email, Pageable pageable);

}
