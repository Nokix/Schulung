package de.schulung.Schulung.rest;

import de.schulung.Schulung.rest.entity.Person;
import de.schulung.Schulung.rest.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public void run(String... args) throws Exception {
        personRepo.save(new Person("Jakob", "Trillsam"));
        personRepo.save(new Person("Jakob", "Jakobsen"));
        personRepo.save(new Person("Nayef", "Swedan"));

        personRepo.findByFirstName("Jakob")
                .forEach(System.out::println);
    }
}
