package de.schulung.Schulung.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Person {
    @Id
    Long id;

    String firstName;
    String lastName;
}
