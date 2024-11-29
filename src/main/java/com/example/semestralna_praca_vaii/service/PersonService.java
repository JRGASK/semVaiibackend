package com.example.semestralna_praca_vaii.service;

import com.example.semestralna_praca_vaii.data.Person;
import com.example.semestralna_praca_vaii.data.PersonRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public class PersonService implements IPersonService{

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Page<Person> getAllPersons(Pageable pageable) {
        return this.personRepository.findAll(pageable);
    }

    @Override
    public Person getPersonByEmail(String email) {
        Optional<Person> person = this.personRepository.findByEmail(email);

        if(person.isEmpty()) {
            return null; //TODO exceptions
        }else {
            return person.get();
        }
    }

    @Override
    public void deletePersonByEmail(String email) {
        Person person = this.getPersonByEmail(email);
        this.personRepository.delete(person);
    }

    @Override
    @Transactional
    public Person addPerson(Person person) {
        if(this.personRepository.existsByEmail(person.getEmail())) {
            return null; //TODO exceptions
        }else {
            return this.personRepository.save(person);
        }
    }
}
