package com.example.semestralna_praca_vaii.controller.login;


import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.RegisterPersonDto;
import com.example.semestralna_praca_vaii.facade.dto.error.ErrorDto;
import com.example.semestralna_praca_vaii.facade.person.PersonFacade;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/login")
public class LoginController {

    private PersonFacade personFacade;

    @Autowired
    public LoginController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }


    @Operation(summary = "login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Found the person",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = PersonDto.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Invalid email or password",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDto.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Invalid email or password",
                    content = @Content(mediaType = "application/json",schema = @Schema(implementation = ErrorDto.class)))
    })

    @PostMapping
    public ResponseEntity<PersonDto> login(Principal principal){

        PersonDto personDto = this.personFacade.getPersonByEmail(principal.getName());

        return new ResponseEntity<PersonDto>(personDto,HttpStatus.OK);
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
    @PostMapping("/register")
    public ResponseEntity<PersonDto> register(@RequestBody RegisterPersonDto registerPersonDto){
        PersonDto personDto = this.personFacade.registerPerson(registerPersonDto);
        return new ResponseEntity<PersonDto>(personDto,HttpStatus.CREATED);
    }
}
