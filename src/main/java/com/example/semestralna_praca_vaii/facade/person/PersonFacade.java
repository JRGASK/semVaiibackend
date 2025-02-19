package com.example.semestralna_praca_vaii.facade.person;

import com.example.semestralna_praca_vaii.data.person.Person;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonUpdateDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.RegisterPersonDto;
import com.example.semestralna_praca_vaii.facade.mapper.PersonMapper;
import com.example.semestralna_praca_vaii.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonFacade implements IPersonFacade{

    private final PersonService personService;

    private final PersonMapper personMapper;

    @Autowired
    public PersonFacade(PersonService personService, PersonMapper personMapper) {
        this.personService = personService;
        this.personMapper = personMapper;
    }

    @Override
    public PagedModel<PersonDto> getAllPersons(Pageable pageable) {
        return this.personMapper.mapToPageCustomerDto(this.personService.getAllPersons(pageable),pageable);
    }

    @Override
    public PersonDto getPersonByEmail(String email) {
        return this.personMapper.mapToPersonDto(this.personService.getPersonByEmail(email));
    }

    @Override
    public void deletePersonByEmail(String email) {
        this.personService.deletePersonByEmail(email);
    }

    @Override
    public PersonDto addPerson(PersonCreateDto personCreateDto) {
        Person person = this.personMapper.mapToPerson(personCreateDto);
        return this.personMapper.mapToPersonDto(this.personService.addPerson(person));
    }

    @Override
    public PersonDto updatePerson(String email, PersonUpdateDto personUpdateDto) {
        Person person = this.personMapper.personUpdateDtoToPerson(personUpdateDto);
        return this.personMapper.mapToPersonDto(this.personService.updatePerson(email,person));
    }

    @Override
    public PersonDto registerPerson(RegisterPersonDto registerPersonDto) {
        Person person = this.personMapper.mapToPerson(registerPersonDto);
        return this.personMapper.mapToPersonDto(this.personService.registerPerson(person));
    }

    @Override
    public List<String> getAllVehiclesByEmail(String email) {
        return this.personService.getVehiclesByEmail(email);
    }

}
