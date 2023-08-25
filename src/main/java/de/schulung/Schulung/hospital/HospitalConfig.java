package de.schulung.Schulung.hospital;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class HospitalConfig {
    @Bean({"firsti", "Vorname"})
    @Qualifier("Apellido")
    public String firstName() {
        return "Nayef";
    }

    @Bean
    @ConditionalOnProperty(value = "modus", havingValue = "super")
    public String lastName() {
        return "Swedan";
    }

    @Bean
    @ConditionalOnProperty(value = "modus", havingValue = "mittel")
    public String nurseFirstName() {
        return "Julia";
    }

    @Bean
    @ConditionalOnMissingBean
    public String nurseLastName() {
        return "Jürgens";
    }

    @Bean
    public String nurseName(
            @Qualifier("lastName") String nurseFirstName,
            @Value("Blablub") String nurseLastName) {
        return nurseFirstName + " " + nurseLastName;
    }
}
