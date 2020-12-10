package com.avllabs.sample.service;

import com.avllabs.sample.entity.Person;
import com.avllabs.sample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepo;

    public Page<Person> findAll(Pageable pag) {
        return personRepo.findAll(pag);
    }

    public Optional<Person> findById(Long id) {
        return personRepo.findById(id);
    }

    public Person save(Person newPerson) {
        newPerson.getAddress().setPerson(newPerson);
        return personRepo.save(newPerson);
    }

    public void delete(Long id) {
        personRepo.delete(personRepo.findById(id).get());
    }

}
