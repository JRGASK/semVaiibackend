package com.example.semestralna_praca_vaii.facade.person;

import com.example.semestralna_praca_vaii.data.Person;
import com.example.semestralna_praca_vaii.facade.dto.PersonCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.PersonDto;
import com.example.semestralna_praca_vaii.facade.mapper.PersonMapper;
import com.example.semestralna_praca_vaii.service.PersonService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.stereotype.Service;

@Service
public class PersonFacade implements IPersonFacade{

    private final PersonService personService;

    private final PersonMapper personMapper;

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
}
