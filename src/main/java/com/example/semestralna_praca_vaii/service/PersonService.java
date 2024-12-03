package com.example.semestralna_praca_vaii.service;

import com.example.semestralna_praca_vaii.controller.exception.ResourceAlreadyExists;
import com.example.semestralna_praca_vaii.controller.exception.ResourceNotFound;
import com.example.semestralna_praca_vaii.data.Person;
import com.example.semestralna_praca_vaii.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Service
public class PersonService implements IPersonService{

    private final PersonRepository personRepository;

    @Autowired
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
            throw new ResourceNotFound(String.format("Person with %s does not exists",email));
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
            throw  new ResourceAlreadyExists(String.format("Person with %s already exists",person.getEmail()));
        }else {
            return this.personRepository.save(person);
        }
    }

    @Override
    @Transactional
    public Person updatePerson(String email, Person personUpdate) {

        Optional<Person> person = this.personRepository.findByEmail(email);
        if(person.isEmpty()) {
            throw new ResourceNotFound(String.format("Person with %s does not exists",personUpdate.getEmail()));
        }else {
            person.get().setName(personUpdate.getName());
            person.get().setSurname(personUpdate.getSurname());
            person.get().setRole(personUpdate.getRole());
            person.get().setPhoneNumber(personUpdate.getPhoneNumber());
            return this.personRepository.save(person.get());
        }
    }
}
