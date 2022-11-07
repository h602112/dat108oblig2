package dat108.hvl.no.fest.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Participant {
    @Id
    private Long mobile;
    private int password;
    private String firstname;
    private String lastname;
    private String gender;

    public Participant() {}

    public Participant(Long mobile, int password, String firstname, String lastname, String gender) {
        this.mobile = mobile;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
