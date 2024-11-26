package mk.finki.ukim.wp.lab.model;

import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class Artist {
    Long id;
    String firstName;
    String lastName;
    String bio;

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
