package com.example.semestralna_praca_vaii.facade.person;

import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.PersonUpdateDto;
import com.example.semestralna_praca_vaii.facade.dto.personDto.RegisterPersonDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

public interface IPersonFacade {

    PagedModel<PersonDto> getAllPersons(Pageable pageable);

    PersonDto getPersonByEmail(String email);

    void deletePersonByEmail(String email);

    PersonDto addPerson(PersonCreateDto personDto);

    PersonDto updatePerson(String email, PersonUpdateDto personUpdateDto);

    PersonDto registerPerson(RegisterPersonDto registerPersonDto);
}
