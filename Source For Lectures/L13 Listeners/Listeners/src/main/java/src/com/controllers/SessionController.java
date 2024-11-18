package src.com.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import src.com.listeners.ActiveSessionListener;

@Controller
@RequestMapping("/sessions")
public class SessionController {

    @GetMapping("/active")
    @ResponseBody
    public String getActiveSessions() {
        return "Active Sessions: " + ActiveSessionListener.getActiveSessions();
    }

    @GetMapping("/create")
    @ResponseBody
    public String createSession(HttpServletRequest request) {
        //Create a new session if it doesn't exist
        HttpSession session = request.getSession(true);
        return "Session created with ID: " + session.getId();
    }

    @GetMapping("/destroy")
    @ResponseBody
    public String destroySession(HttpServletRequest request) {
        //Get the session if it exists
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
            return "Session with ID: " + session.getId() + " destroyed.";
        } else {
            return "No active session found to destroy.";
        }
    }

}

