package de.schulung.Schulung.rest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
@ToString
public class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    @ToString.Exclude
    @ManyToMany
    @JoinTable(name = "friends",
            joinColumns = @JoinColumn(name = "person_1_id"),
            inverseJoinColumns = @JoinColumn(name = "persons_2_id"))
    private Set<Person> friends = new LinkedHashSet<>();

    public void setFriends(Set<Person> friends) {
        this.friends = friends;
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
