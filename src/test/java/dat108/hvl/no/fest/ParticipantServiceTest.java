package dat108.hvl.no.fest;

import dat108.hvl.no.fest.model.Participant;
import dat108.hvl.no.fest.repository.ParticipantRepository;
import dat108.hvl.no.fest.service.ParticipantService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParticipantServiceTest {

     @InjectMocks
    ParticipantService ps;

     @Mock
    ParticipantRepository pr;

     //Dont understand why this test is giving an error, getAllParticipants uses findAll method, so should work
     @Test
    void findAllParticipants() {
         when(pr.findAll()).thenReturn(List.of(
                 new Participant("Knut"),
                 new Participant("Lars"),
                 new Participant("Mona")
         ));

         List<Participant> result = ps.getAllParticipants();

         assertEquals(3, result.size());
         assertTrue(result.contains("Knut"));
         assertFalse(result.contains("Per"));
     }

}
