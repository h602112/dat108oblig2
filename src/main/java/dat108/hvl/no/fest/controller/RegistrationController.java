package dat108.hvl.no.fest.controller;

import dat108.hvl.no.fest.model.Participant;
import dat108.hvl.no.fest.service.ParticipantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    private ParticipantService participantService;

    public RegistrationController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("/registration")
    public String registrationForm() {
        return "registration";
    }

    @PostMapping ("/registration")
    public String submitRegistration(@ModelAttribute("participant") Participant participant, Model model) {
        participantService.saveParticipant(participant);
        model.addAttribute("participant", participant);
        return "redirect:/registrated";
    }

    @GetMapping("/registrated")
    public String registratedForm() {
        return "registrated";
    }

}
