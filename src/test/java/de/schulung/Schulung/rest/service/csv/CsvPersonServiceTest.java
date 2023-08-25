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
        List<Person> personList = csvPersonService.readCsv("persons.csv");

        personList.forEach(System.out::println);
    }
}