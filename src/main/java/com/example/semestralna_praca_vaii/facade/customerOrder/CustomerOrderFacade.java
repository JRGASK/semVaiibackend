package com.example.semestralna_praca_vaii.facade.customerOrder;

import com.example.semestralna_praca_vaii.data.customerOrder.CustomerOrder;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderUpdateDto;
import com.example.semestralna_praca_vaii.facade.mapper.CustomerOrderMapper;
import com.example.semestralna_praca_vaii.service.customerOrder.ICustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class CustomerOrderFacade implements ICustomerOrderFacade{

    private final ICustomerOrderService customerOrderService;

    private final CustomerOrderMapper customerOrderMapper;

    @Autowired
    public CustomerOrderFacade(ICustomerOrderService customerOrderService, CustomerOrderMapper customerOrderMapper) {
        this.customerOrderService = customerOrderService;
        this.customerOrderMapper = customerOrderMapper;
    }

    @Override
    public PagedModel<CustomerOrderDto> getAllCustomerOrders(Pageable pageable) {
        return this.customerOrderMapper.mapToPageDto(this.customerOrderService.getAllCustomerOrders(pageable),pageable);
    }

    @Override
    public CustomerOrderDto getCustomerOrderById(Long id) {
        return this.customerOrderMapper.mapToCustomerOrderDto(this.customerOrderService.getCustomerOrderById(id));
    }

    @Override
    public CustomerOrderDto addCustomerOrder(CustomerOrderCreateDto customerOrderCreateDto) {
        CustomerOrder customerOrder = this.customerOrderMapper.mapToCustomerOrder(customerOrderCreateDto);
        return this.customerOrderMapper.mapToCustomerOrderDto(this.customerOrderService.addCustomerOrder(customerOrder));
    }

    @Override
    public CustomerOrderDto updateCustomerOrder(Long id, CustomerOrderUpdateDto customerOrderUpdateDto) {
        CustomerOrder customerOrder = this.customerOrderMapper.mapCustomerOrderUpdateDtoToCustomerOrder(customerOrderUpdateDto);
        return this.customerOrderMapper.mapToCustomerOrderDto(this.customerOrderService.updateCustomerOrder(id,customerOrder));
    }

    @Override
    public void deleteCustomerOrderById(Long id) {
        this.customerOrderService.deleteCustomerOrderById(id);
    }

    @Override
    public PagedModel<CustomerOrderDto> getCustomerOrdersByEmail(String email, Pageable pageable) {
        return this.customerOrderMapper.mapToPageDto(this.customerOrderService.getCustomerOrdersByEmail(email,pageable),pageable);
    }
}
