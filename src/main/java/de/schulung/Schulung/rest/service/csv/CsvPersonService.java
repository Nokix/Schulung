package de.schulung.Schulung.rest.service.csv;

import de.schulung.Schulung.rest.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

@Service
@RequiredArgsConstructor
public class CsvPersonService {
    private final ResourceLoader resourceLoader;

    public List<Person> readCsv(String csvFilePath) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:" + csvFilePath);
        return readCsV(resource);
    }

    private List<Person> readCsV(Resource resource) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            CsvToBean<Person> csvToBean = new CsvToBeanBuilder<Person>(reader)
                    .withType(Person.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        }
    }
}
