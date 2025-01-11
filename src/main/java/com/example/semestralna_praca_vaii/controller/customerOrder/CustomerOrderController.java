package com.example.semestralna_praca_vaii.controller.customerOrder;

import com.example.semestralna_praca_vaii.data.customerOrder.CustomerOrder;
import com.example.semestralna_praca_vaii.facade.customerOrder.CustomerOrderFacade;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customerOrder")
public class CustomerOrderController {

    private final CustomerOrderFacade customerOrderFacade;

    @Autowired
    public CustomerOrderController(CustomerOrderFacade customerOrderFacade) {
        this.customerOrderFacade = customerOrderFacade;
    }

    @Operation(summary = "Get all customers orders")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" ,
                    description = "Found customer orders",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerOrder.class)) })
    })
    @GetMapping
    public ResponseEntity<PagedModel<CustomerOrderDto>> getAllCustomerOrders(@ParameterObject Pageable pageable){
        PagedModel<CustomerOrderDto> customerOrderDtos = this.customerOrderFacade.getAllCustomerOrders(pageable);
        return new ResponseEntity<>(customerOrderDtos, HttpStatus.OK);
    }


}
