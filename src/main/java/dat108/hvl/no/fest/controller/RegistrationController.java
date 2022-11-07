package dat108.hvl.no.fest.controller;

import dat108.hvl.no.fest.model.Participant;
import dat108.hvl.no.fest.service.ParticipantService;
import dat108.hvl.no.fest.util.LoggedInUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
    public String submitRegistration(@ModelAttribute("participant") Participant participant,
                                     RedirectAttributes ra, HttpServletRequest request) {
        participantService.saveParticipant(participant);
        ra.addFlashAttribute("participant", participant);
        LoggedInUtil.logInUser(request, participant);
        return "redirect:/registrated";
    }

    @GetMapping("/registrated")
    public String registratedForm() {
        return "registrated";
    }

    @GetMapping("/participantslist")
    public String participantsList(Model model) {
        model.addAttribute("participants", participantService.getAllParticipants());
        return "participantslist";
    }

    @PostMapping("/participantslist")
    public String logOut() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm(HttpSession session) {
        return "login";
    }

}
