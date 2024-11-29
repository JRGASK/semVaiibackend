package com.example.semestralna_praca_vaii.service;

import com.example.semestralna_praca_vaii.data.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPersonService {

    Page<Person> getAllPersons(Pageable pageable);

    Person getPersonByEmail(String email);

    void deletePersonByEmail(String email);

   Person addPerson(Person person);
}
