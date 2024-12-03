package com.example.semestralna_praca_vaii.facade.mapper;

import com.example.semestralna_praca_vaii.data.Person;
import com.example.semestralna_praca_vaii.facade.dto.PersonCreateDto;
import com.example.semestralna_praca_vaii.facade.dto.PersonDto;
import com.example.semestralna_praca_vaii.facade.dto.PersonLoginDto;
import com.example.semestralna_praca_vaii.facade.dto.PersonUpdateDto;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    List<PersonDto> mapToListPersonDto(List<Person> person);

    Person mapToPerson(PersonCreateDto personCreateDto);

    PersonDto mapToPersonDto(Person person);

    Person personUpdateDtoToPerson(PersonUpdateDto personUpdateDto);

    PersonLoginDto mapToPersonLoginDto(Person person);

    default PagedModel<PersonDto> mapToPageCustomerDto(Page<Person> personPage, Pageable pageable) {
        List<PersonDto> personDtos = mapToListPersonDto(personPage.getContent());
        Page<PersonDto> personDtoPage = new PageImpl<>(personDtos, pageable, personPage.getTotalElements());
        return new PagedModel<PersonDto>(personDtoPage);
    }
}
