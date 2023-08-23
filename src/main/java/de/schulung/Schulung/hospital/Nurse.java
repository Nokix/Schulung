package de.schulung.Schulung.hospital;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Nurse {

    private String firstName;

    public Nurse(@Qualifier("lastName") String firstName) {
        this.firstName = firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String assist() {
        return "Nurse " + this.firstName + " is helping";
    }
}
