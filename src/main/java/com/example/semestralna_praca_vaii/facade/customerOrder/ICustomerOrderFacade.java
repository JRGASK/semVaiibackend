package com.example.semestralna_praca_vaii.facade.customerOrder;

import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderUpdateDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

public interface ICustomerOrderFacade {

    PagedModel<CustomerOrderDto> getAllCustomerOrders(Pageable pageable);

    CustomerOrderDto getCustomerOrderById(Long id);

    CustomerOrderDto addCustomerOrder(CustomerOrderCreateDto customerOrderCreateDto);

    CustomerOrderDto updateCustomerOrder(Long id, CustomerOrderUpdateDto customerOrderUpdateDto);

    void deleteCustomerOrderById(Long id);

    PagedModel<CustomerOrderDto> getCustomerOrdersByEmail(String email, Pageable pageable);

}
