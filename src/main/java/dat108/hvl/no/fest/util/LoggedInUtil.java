package dat108.hvl.no.fest.util;

import dat108.hvl.no.fest.model.Participant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggedInUtil {

    public static void logOutUser(HttpSession session) { session.invalidate(); }

    public static void logInUser(HttpServletRequest request, Participant participant) {

        logOutUser(request.getSession());

        HttpSession session = request.getSession();
        session.setAttribute("user", participant);
    }
}
