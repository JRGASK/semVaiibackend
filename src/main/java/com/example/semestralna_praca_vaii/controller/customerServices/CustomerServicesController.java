package com.example.semestralna_praca_vaii.controller.customerServices;

import com.example.semestralna_praca_vaii.data.customerServices.CustomerServices;
import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.facade.customerServices.CustomerServicesFacade;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesCreteDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesDto;
import com.example.semestralna_praca_vaii.facade.dto.CustomerServicesDto.CustomerServicesUpdateDto;
import com.example.semestralna_praca_vaii.facade.dto.error.ErrorDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonDto;
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
@RequestMapping("/customerServices")
public class CustomerServicesController {

    private final CustomerServicesFacade customerServicesFacade;

    @Autowired
    public CustomerServicesController(CustomerServicesFacade customerServicesFacade) {
        this.customerServicesFacade = customerServicesFacade;
    }

    @Operation(summary = "Get all customer services")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" ,
                    description = "Found customer services",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerServicesDto.class)) })
    })
    @GetMapping
    public ResponseEntity<PagedModel<CustomerServicesDto>> getAllCustomerServices(@ParameterObject Pageable pageable){
        PagedModel<CustomerServicesDto> customerServicesDtos = this.customerServicesFacade.getAllCustomerServices(pageable);
        return new ResponseEntity<>(customerServicesDtos, HttpStatus.OK);
    }

    @Operation(summary = "Get customer service by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the customer service",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerServicesDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid id",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Customer service not found",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorDto.class)))
    })
    @GetMapping(path = "/customerService/{id}")
    public ResponseEntity<CustomerServicesDto> getCustomerServicesById(@Parameter(description = "id of customer service") @PathVariable("id") Integer id){
        CustomerServicesDto customerServicesDto = this.customerServicesFacade.getCustomerServiceById(id);
        return new ResponseEntity<>(customerServicesDto, HttpStatus.OK);
    }

    @Operation(summary = "Delete customer service by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Customer service deleted successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CustomerServicesCreteDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid customer service id",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Customer service not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @DeleteMapping(path = "/customerService/{id}")
    public ResponseEntity<Void> deleteCustomerServicesById(@PathVariable("id") Integer id){
        this.customerServicesFacade.deleteCustomerServiceById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Create a customer service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Customer service created successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid customer service data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "409",
                    description = "Customer service already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })

    @PostMapping(path = "/customerService")
    public ResponseEntity<CustomerServicesDto> addCustomerServices(@RequestBody CustomerServicesCreteDto customerServicesCreteDto){
        CustomerServicesDto customerServicesDto = this.customerServicesFacade.addCustomerService(customerServicesCreteDto);
        return new ResponseEntity<>(customerServicesDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a customer service")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Customer service updated successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid customer service data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "409",
                    description = "Customer service already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @PutMapping(path = "/customerService/{id}")
    public ResponseEntity<CustomerServicesDto> updateCustomerServices(@PathVariable("id") Integer id, @RequestBody CustomerServicesUpdateDto customerServicesUpdateDto){
        CustomerServicesDto customerServicesDto = this.customerServicesFacade.updateCustomerService(id,customerServicesUpdateDto);
        return new ResponseEntity<>(customerServicesDto, HttpStatus.OK);
    }
}
