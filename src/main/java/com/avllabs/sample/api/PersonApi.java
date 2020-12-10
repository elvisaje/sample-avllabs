package com.avllabs.sample.api;

import java.util.Optional;
import javax.validation.Valid;

import com.avllabs.sample.entity.Person;
import com.avllabs.sample.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonApi {

    @Autowired
    private PersonService personService;

    @GetMapping("/persons")
    public ResponseEntity<Page<Person>> findAll(Pageable pag) {
        return new ResponseEntity(personService.findAll(pag), HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> findById(@PathVariable Long id) {

        Optional<Person> result = personService.findById(id);

        if (result.isPresent()) {
            return new ResponseEntity(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> save(@Valid @RequestBody Person newPerson) {
        return new ResponseEntity(personService.save(newPerson), HttpStatus.CREATED);
    }

    @PutMapping("/persons")
    public ResponseEntity<Person> update(@Valid @RequestBody Person updatedPerson) {

        Long id = (updatedPerson.getId() == null) ? -1 : updatedPerson.getId();

        Optional<Person> p = personService.findById(id).map(person -> {

            person.setName(updatedPerson.getName());
            person.setPhone(updatedPerson.getPhone());
            person.setEmail(updatedPerson.getEmail());

            person.getAddress().setStreet(updatedPerson.getAddress().getStreet());
            person.getAddress().setCity(updatedPerson.getAddress().getCity());
            person.getAddress().setState(updatedPerson.getAddress().getState());
            person.getAddress().setPostalCode(updatedPerson.getAddress().getPostalCode());
            person.getAddress().setCountry(updatedPerson.getAddress().getCountry());

            return personService.save(person);
        });

        return new ResponseEntity(p.get(), HttpStatus.OK);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        personService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
