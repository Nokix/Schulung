package de.schulung.Schulung.hospital;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Nurse {

    private String name;

    public Nurse(@Qualifier("nurseName") String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String assist() {
        return "Nurse " + this.name + " is helping";
    }
}
