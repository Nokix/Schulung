package de.schulung.Schulung.rest.service;

import de.schulung.Schulung.rest.entity.Person;
import de.schulung.Schulung.rest.repository.PersonRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    final PersonRepo personRepo;

    public List<Person> findAll() {
        return personRepo.findAll();
    }

    public Person save(Person person) {
        return personRepo.save(person);
    }

    public Optional<Person> getById(Long id) {
        return personRepo.findById(id);
    }

}
