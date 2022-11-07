package dat108.hvl.no.fest.service;

import dat108.hvl.no.fest.model.Participant;

import java.util.List;

public interface ParticipantService {

    List<Participant> getAllParticipants();
    Participant saveParticipant(Participant participant);
    Participant getParticipantById(Long id);
}
