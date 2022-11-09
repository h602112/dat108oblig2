package dat108.hvl.no.fest.controller;

import dat108.hvl.no.fest.model.Participant;
import dat108.hvl.no.fest.service.ParticipantService;
import dat108.hvl.no.fest.util.LoginUtil;
import dat108.hvl.no.fest.util.PasswordUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegistrationController {

    @Value("${app.message.loginMsg}") private String LOGIN_MSG;
    @Value("${app.message.invalidMsg}") private String INVALID_LOGIN_MSG;

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
        LoginUtil.logInUser(request, participant);
        return "redirect:/registrated";
    }

    @GetMapping("/registrated")
    public String registratedForm(HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", LOGIN_MSG);
            return "redirect:/login";
        }

        return "registrated";
    }

    @GetMapping("/participantslist")
    public String participantsList(Model model, HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.isUserLoggedIn(session)) {
            ra.addFlashAttribute("redirectMessage", LOGIN_MSG);
            return "redirect:/login";
        }

        model.addAttribute("participants", participantService.getAllParticipants());
        return "participantslist";
    }

    @PostMapping("/participantslist")
    public String logOut(HttpSession session, RedirectAttributes ra) {

        if (LoginUtil.isUserLoggedIn(session)) {
            LoginUtil.logOutUser(session);
            ra.addFlashAttribute("redirectMessage", LOGIN_MSG);
            return "redirect:/login";
        }
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginForm() { return "login"; }

    @PostMapping("/login")
    public String submitLogin(@RequestParam(name = "mobile") Long id,
                              @RequestParam(name = "password") String pw,
                              HttpServletRequest request, RedirectAttributes ra) {

        Participant participant = participantService.getParticipantById(id);
        String salt = participant.getSalt();
        String hashedPassword = PasswordUtil.hashWithSalt(pw, salt);

        if (participant == null) {
            ra.addFlashAttribute("redirectMessage", INVALID_LOGIN_MSG);
            return "redirect:/login";
        }

        if (!id.equals(participant.getMobile()) || !pw.equals(participant.getPassword()) ||
                !(PasswordUtil.validateWithSalt(pw, salt, hashedPassword))) {
            ra.addFlashAttribute("redirectMessage", INVALID_LOGIN_MSG);
            return "redirect:/login";
        }

        ra.addFlashAttribute("participant", participant);
        LoginUtil.logInUser(request, participant);
        return "redirect:/participantslist";
    }

}
