package com.example.semestralna_praca_vaii.controller.login;

import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.RegisterPersonDto;
import com.example.semestralna_praca_vaii.facade.person.PersonFacade;
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

    private final PersonFacade personFacade;

    @Autowired
    public LoginController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }


    @PostMapping
    public ResponseEntity<PersonDto> login(Principal principal){

        PersonDto personDto = this.personFacade.getPersonByEmail(principal.getName());
        System.out.println("Controler>" + personDto);
        return new ResponseEntity<PersonDto>(personDto,HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<PersonDto> register(@RequestBody RegisterPersonDto registerPersonDto){
        PersonDto personDto = this.personFacade.registerPerson(registerPersonDto);
        return new ResponseEntity<PersonDto>(personDto,HttpStatus.CREATED);
    }
}
