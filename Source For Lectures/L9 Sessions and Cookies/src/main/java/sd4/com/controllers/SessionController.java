package sd4.com.controllers;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    // Set a username in the session
    @GetMapping("/setUsername")
    public String setUsername(HttpSession session, Model model) {
        session.setAttribute("username", "JohnDoe"); // Setting username into session
        model.addAttribute("message", "Username has been set in session.");
        return "sessions/sessionSet";
    }

    // Access the username from the session and display it
    @GetMapping("/displayUsername")
    public String displayUsername(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            model.addAttribute("message", "No username found in session.");
        } else {
            model.addAttribute("message", "Username from session: " + username);
        }
        return "sessions/sessionDisplay";
    }

    // Logout and invalidate the session
    @GetMapping("/logout")
    public String logout(HttpSession session, Model model) {
        session.invalidate(); // Invalidate the session
        model.addAttribute("message", "You have been logged out.");
        return "sessions/sessionLogout";
    }



    // Set a username in the session and encode the URL if necessary
    @GetMapping("session/set")
    public String setSession(HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        session.setAttribute("username", "JohnDoe");

        // Encode the URL to append session ID if necessary
        String url = response.encodeURL(request.getContextPath() + "/session/get");

        model.addAttribute("message", "Session data has been set. Click below to get the session data.");
        model.addAttribute("getUrl", url);

        return "sessions/sessionSetV2";
    }

    // Retrieve the username from the session
    @GetMapping("session/get")
    public String getSession(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");

        if (username == null) {
            model.addAttribute("message", "No username found in session.");
        } else {
            model.addAttribute("message", "Username from session: " + username);
        }

        return "sessions/sessionGet";
    }



}
