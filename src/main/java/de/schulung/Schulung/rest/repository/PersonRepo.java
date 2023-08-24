package de.schulung.Schulung.rest.repository;

import de.schulung.Schulung.rest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface PersonRepo extends JpaRepository<Person, Long> {
    Collection<Person> findByFirstName(String name);

    //JPQL
    @Query("""
            select p from Person p
            where upper(p.firstName) like upper(concat('%', ?1)) and upper(p.lastName) like upper(concat(?2, '%'))
            order by p.firstName""")
    Set<Person> getSpecialPersons(String firstName, String lastName);

    @Query(value = "select * from Person", nativeQuery = true)
    Optional<Person> findBest();

    Set<Person> findByFirstNameContainsIgnoreCase(String firstName);

    Collection<Person> findByLastNameStartsWithIgnoreCaseOrFirstNameEndsWithIgnoreCaseOrderByFirstNameAsc(String lastName, String firstName);
}
