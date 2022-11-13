package dat108.hvl.no.fest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import dat108.hvl.no.fest.util.PasswordUtil;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Transient;
import javax.servlet.http.Part;
import javax.validation.constraints.*;

@Entity
public class Participant implements Comparable<Participant>{
    @Id
    @Digits(integer = 8, fraction = 0, message = "must be exactly 8 digits")
    private Long mobile;
    @Column(length = 255)
    private String hashedPassword;
    @Column(length = 255)
    private String salt;
    @Column(length = 20)
    @Size(min = 2, max = 20)
    private String firstname;
    @Column(length = 20)
    @Size(min = 2, max = 20)
    private String lastname;
    @Column(length = 5)
    @NotBlank
    private String gender;
    @Transient
    @Size(min = 7, message = "size must be minimum 7 characters")
    private String password;

    public Participant() {}

    public Participant(Long mobile, String password, String firstname, String lastname, String gender) {
        this.mobile = mobile;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
    }

    @Override
    public int compareTo(Participant participant) {
        return this.firstname.compareTo(participant.getFirstname());
    }

    public void generateSaltAndHashedPassword() {
        setSalt(PasswordUtil.generateRandomSalt());
        setHashedPassword(PasswordUtil.hashWithSalt(this.password, this.salt));
    }

    public Long getMobile() {
        return mobile;
    }

    public void setMobile(Long mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
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

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
