package de.schulung.Schulung;

import de.schulung.Schulung.hospital.Doctor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class SchulungApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext =
				SpringApplication.run(SchulungApplication.class, args);

		Doctor doctor = applicationContext.getBean(Doctor.class);

		System.out.println(doctor.assist());

//		Arrays.stream(applicationContext.getBeanDefinitionNames()).
//				forEach(System.out::println);
//
//		Arrays.stream(applicationContext.getAliases(("firsti")))
//				.forEach(System.out::println);

	}
}
