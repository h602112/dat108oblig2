package dat108.hvl.no.fest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participant {
    @Id
    private int mobile;
    private String password;
    private String firstname;
    private String lastname;
    private Gender gender;
}
