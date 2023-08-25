package de.schulung.Schulung.rest.controller;

import de.schulung.Schulung.rest.entity.Person;
import de.schulung.Schulung.rest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    final PersonService personService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person findById(@PathVariable Long id) {
        return personService.getById(id).orElseThrow();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person saveNewPerson(@RequestBody Person person) {
        return personService.save(person);
    }


}
