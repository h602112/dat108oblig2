package dat108.hvl.no.fest;

import dat108.hvl.no.fest.model.Participant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.persistence.Persistence;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParticipantValidationTest {

    private Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    public void validValues() {
        Participant participant = new Participant(12345678L, "HEllo123", "Lars",
                "Larsen", "man");
        assertTrue(hasValid("firstName", participant));
        assertTrue(hasValid("lastName", participant));
        assertTrue(hasValid("mobile", participant));
        assertTrue(hasValid("Gender", participant));
        assertTrue(hasValid("password", participant));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "a", "Lars Monsen Hansen Pedersen"})
    public void invalidFirstNames(String name) {
        Participant participant = new Participant(12345678L, "12345678", name,
                "Larsen", "man");
        assertFalse(hasValid("firstName", participant));
    }

    private boolean hasValid(String fieldName, Participant participant) {
        List<String> invalidField = validator.validate(participant).stream()
                .map(v -> v.getPropertyPath().toString())
                .toList();

        return !invalidField.contains(fieldName);
    }

}
