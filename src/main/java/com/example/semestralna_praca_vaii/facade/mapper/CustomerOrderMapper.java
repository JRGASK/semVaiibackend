package com.example.semestralna_praca_vaii.facade.mapper;

import com.example.semestralna_praca_vaii.data.customerOrder.CustomerOrder;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderUpdateDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerOrderMapper {

    List<CustomerOrderDto> mapToListCustomerOrder(List<CustomerOrder> customerOrder);

    CustomerOrderDto mapToCustomerOrderDto(CustomerOrder customerOrder);

    CustomerOrder mapToCustomerOrder(CustomerOrderCreateDto customerOrderCreateDto);

    CustomerOrder mapCustomerOrderUpdateDtoToCustomerOrder(CustomerOrderUpdateDto customerOrderUpdateDto);

    default PagedModel<CustomerOrderDto> mapToPageDto(Page<CustomerOrder> customerOrdersPage, Pageable pageable) {
        List<CustomerOrderDto> customerOrdersDtos = mapToListCustomerOrder(customerOrdersPage.getContent());
        Page<CustomerOrderDto> customerOrderPage = new PageImpl<>(customerOrdersDtos, pageable, customerOrdersPage.getTotalElements());
        return new PagedModel<CustomerOrderDto>(customerOrderPage);
    }

}
