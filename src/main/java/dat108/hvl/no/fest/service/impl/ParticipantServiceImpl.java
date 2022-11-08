package dat108.hvl.no.fest.service.impl;

import dat108.hvl.no.fest.model.Participant;
import dat108.hvl.no.fest.repository.ParticipantRepository;
import dat108.hvl.no.fest.service.ParticipantService;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.util.Collections;
import java.util.List;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    private ParticipantRepository participantRepository;

    public ParticipantServiceImpl(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public List<Participant> getAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        Collections.sort(participants);
        return participants;
    }

    @Override
    public Participant saveParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public Participant getParticipantById(Long id) {
        return participantRepository.findById(id).orElse(null);
    }
}
