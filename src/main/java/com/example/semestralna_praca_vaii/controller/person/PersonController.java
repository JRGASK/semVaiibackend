package com.example.semestralna_praca_vaii.controller.person;


import com.example.semestralna_praca_vaii.data.Person;
import com.example.semestralna_praca_vaii.facade.dto.PersonCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.PersonDto;
import com.example.semestralna_praca_vaii.facade.dto.PersonUpdateDto;
import com.example.semestralna_praca_vaii.facade.dto.error.ErrorDto;
import com.example.semestralna_praca_vaii.facade.person.PersonFacade;
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
@RequestMapping("persons")
public class PersonController {

    private final PersonFacade personFacade;


    @Autowired
    public PersonController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @Operation(summary = "Get all persons")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200" ,
                    description = "Found persons",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDto.class)) })
    })
    @GetMapping
    public ResponseEntity<PagedModel<PersonDto>> getAllPersons(@ParameterObject Pageable pageable){
        PagedModel<PersonDto> personDtoPagedModel = this.personFacade.getAllPersons(pageable);
        return new ResponseEntity<>(personDtoPagedModel, HttpStatus.OK);
    }

    @Operation(summary = "Get person by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the person",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid Email",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Person not found",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorDto.class)))
    })

    @GetMapping(path = "person/{email}")
    public ResponseEntity<PersonDto> getPersonByEmail(@Parameter(description = "email of person") @PathVariable("email") String email){
        PersonDto personDto = this.personFacade.getPersonByEmail(email);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

    @Operation(summary = "Delete person by email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Person deleted successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonCreateDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid person email",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Person not found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @DeleteMapping(path = "person/{email}")
    public ResponseEntity<Void> deletePersonByEmail(@PathVariable("email") String email){
        this.personFacade.deletePersonByEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Create a new person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Customer created successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid person data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "409",
                    description = "Person already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })

    @PostMapping(path = "/person")
    public ResponseEntity<PersonDto> addPerson(@RequestBody PersonCreateDto personCreateDto){
        PersonDto personDto = this.personFacade.addPerson(personCreateDto);
        return new ResponseEntity<>(personDto, HttpStatus.CREATED);
    }

    @Operation(summary = "Update a person")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Customer updated successfully ",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid person data",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "409",
                    description = "Person already exists",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)))
    })
    @PutMapping(path = "/person/{email}")
    public ResponseEntity<PersonDto> updatePerson(@PathVariable("email") String email, @RequestBody PersonUpdateDto personUpdateDto){
        PersonDto personDto = this.personFacade.updatePerson(email,personUpdateDto);
        return new ResponseEntity<>(personDto, HttpStatus.OK);
    }

}
