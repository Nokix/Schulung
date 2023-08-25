package de.schulung.Schulung.rest.service.csv;

import de.schulung.Schulung.rest.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CsvPersonServiceTest {
    @Autowired
    CsvPersonService csvPersonService;

    @Test
    public void testCsvRead() throws IOException {

        Person person1 = Person.builder()
                .id(1L)
                .firstName("Karl")
                .lastName("Karlson")
                .build();
        Person person2 = Person.builder().id(2L).firstName("Theo").lastName("Logi").build();

        List<Person> personList = csvPersonService.readCsv("persons.csv");

        assertEquals(List.of(person1, person2), personList);
    }
}