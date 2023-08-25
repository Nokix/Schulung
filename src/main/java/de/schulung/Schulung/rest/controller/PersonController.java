package de.schulung.Schulung.rest.controller;

import de.schulung.Schulung.rest.entity.Person;
import de.schulung.Schulung.rest.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    final PersonService personService;

    @GetMapping(consumes = "text/csv")
    public List<Person> findAll() {
        return personService.findAll();
    }


}
