package com.example.semestralna_praca_vaii.controller.customerOrder;

import com.example.semestralna_praca_vaii.data.customerOrder.CustomerOrder;
import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.facade.customerOrder.CustomerOrderFacade;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesCreteDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderDto;
import com.example.semestralna_praca_vaii.facade.dto.customerOrderDto.CustomerOrderUpdateDto;
import com.example.semestralna_praca_vaii.facade.dto.error.ErrorDto;
import com.example.semestralna_praca_vaii.facade.dto.vehicleDto.VehicleCreateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "Get customer order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the customer order",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerOrderDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid id",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Customer order not found",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorDto.class)))
    })
    @GetMapping(path = "/customerOrders/customerOrder/{id}")
    public ResponseEntity<CustomerOrderDto> getCustomerOrderById(@Parameter(description = "id of customer order") @PathVariable("id") Long id){
        CustomerOrderDto customerOrderDto = this.customerOrderFacade.getCustomerOrderById(id);
        return new ResponseEntity<>(customerOrderDto, HttpStatus.OK);
    }

    @Operation(summary = "Get customer order by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the customer order",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerOrderDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid email",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Customer order not found",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorDto.class)))
    })
    @GetMapping(path = "/customerOrder/{email}")
    public ResponseEntity<PagedModel<CustomerOrderDto>> getCustomerOrderByEmail(@Parameter(description = "email of customer order") @PathVariable("email") String email, @ParameterObject Pageable pageable){
        PagedModel<CustomerOrderDto> customerOrderDtos = this.customerOrderFacade.getCustomerOrdersByEmail(email,pageable);
        return new ResponseEntity<>(customerOrderDtos, HttpStatus.OK);
    }

    @Operation(summary = "Create a customer order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Customer order created successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerOrderCreateDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid customer order data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "409",
                    description = "Customer order already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })

    @PostMapping(path = "/customerOrder")
    public ResponseEntity<CustomerOrderDto> addCustomerOrder(@RequestBody CustomerOrderCreateDto customerOrderCreateDto){
        CustomerOrderDto customerOrderDto = this.customerOrderFacade.addCustomerOrder(customerOrderCreateDto);
        return new ResponseEntity<>(customerOrderDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a customer order")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Customer order updated successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerOrderUpdateDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid customer order data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "409",
                    description = "Customer order already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @PutMapping(path = "/customerOrder/{id}")
    public ResponseEntity<CustomerOrderDto> updateCustomerOrder(@PathVariable("id") Long id, @RequestBody CustomerOrderUpdateDto customerOrderUpdateDto){
        CustomerOrderDto customerOrderDto = this.customerOrderFacade.updateCustomerOrder(id,customerOrderUpdateDto);
        return new ResponseEntity<>(customerOrderDto, HttpStatus.OK);
    }

    @Operation(summary = "Delete customer order by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Customer order deleted successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerOrderDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid order service id",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Customer order not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @DeleteMapping(path = "/customerOrder/{id}")
    public ResponseEntity<CustomerOrderDto> deleteCustomerOrderById(@PathVariable("id") Long id){
        this.customerOrderFacade.deleteCustomerOrderById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
