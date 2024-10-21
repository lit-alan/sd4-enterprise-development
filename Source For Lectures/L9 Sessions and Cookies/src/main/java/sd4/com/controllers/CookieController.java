package sd4.com.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {

    // Set a cookie
    @GetMapping("/setCookie")
    public String setCookie(HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("username", "JohnDoe");
        cookie.setMaxAge(7 * 24 * 60 * 60); // 7 days
        cookie.setPath("/");  // Cookie is accessible on entire site
        response.addCookie(cookie);
        model.addAttribute("message", "Cookie for username has been set.");
        return "cookies/cookieSet";
    }

    // Get a cookie
    @GetMapping("/getCookie")
    public String getCookie(@CookieValue(value = "username", defaultValue = "defaultUser") String username, Model model) {
        model.addAttribute("message", "User from cookie: " + username);
        return "cookies/cookieGet";
    }
        // Remove a cookie
        @GetMapping("/removeCookie")
        public String removeCookie(HttpServletResponse response, Model model) {
            Cookie cookie = new Cookie("username", null);
            cookie.setMaxAge(0);  // Delete the cookie by setting max age to 0
            response.addCookie(cookie);
            model.addAttribute("message", "Username cookie has been removed.");
            return "cookies/cookieRemove";
        }
}
