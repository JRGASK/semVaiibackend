package com.example.semestralna_praca_vaii.service;

import com.example.semestralna_praca_vaii.data.Person;
import com.example.semestralna_praca_vaii.data.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class customUserDetailsServiceImpl implements UserDetailsService {

    private final PersonRepository personRepository;

    @Autowired
    public customUserDetailsServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = personRepository.findByEmail(username);

        if(person.isEmpty()) {
            throw new UsernameNotFoundException(String.format("Person with %s does not exists",username));
        }

        return new UserDetails() {

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {

                Set<SimpleGrantedAuthority> authorities = new HashSet<>();

                authorities.add(new SimpleGrantedAuthority(person.get().getRole().name()));

                return authorities;
            }

            @Override
            public String getPassword() {
                return person.get().getPassword();
            }

            @Override
            public String getUsername() {
                return person.get().getEmail();
            }
        };
    }
}
