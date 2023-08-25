package de.schulung.Schulung.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}
