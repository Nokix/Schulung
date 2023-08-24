package de.schulung.Schulung.hospital;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Setter
@Scope("prototype")
public class Doctor {
    String firstName;
    String lastName;
    Nurse nurse;

    public Doctor(
            @Qualifier("Apellido") String firstName,
            String lastName,
            Nurse nurse) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nurse = nurse;
    }

    public String assist() {
        return "Doctor "
                + this.firstName
                + " "
                + lastName
                + " is assisting. "
                + this.nurse.assist();
    }
}
