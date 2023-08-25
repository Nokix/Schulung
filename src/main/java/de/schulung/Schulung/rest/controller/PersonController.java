package de.schulung.Schulung.rest.controller;

import de.schulung.Schulung.rest.entity.Person;
import de.schulung.Schulung.rest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    final PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return personService.findAll();
    }

    @PostMapping
    public Person saveNewPerson(@RequestBody Person person) {
        return personService.save(person);
    }
}
