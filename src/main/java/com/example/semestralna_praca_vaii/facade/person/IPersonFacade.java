package com.example.semestralna_praca_vaii.facade.person;

import com.example.semestralna_praca_vaii.facade.dto.PersonCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.PersonDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

public interface IPersonFacade {

    PagedModel<PersonDto> getAllPersons(Pageable pageable);

    PersonDto getPersonByEmail(String email);

    void deletePersonByEmail(String email);

    PersonDto addPerson(PersonCreateDto personDto);
}
