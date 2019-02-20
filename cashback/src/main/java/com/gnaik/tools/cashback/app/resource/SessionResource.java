package com.gnaik.tools.cashback.app.resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/session")
public class SessionResource {

    @GetMapping
    public String getSessionId(HttpSession session, Model model){
        model.addAttribute("sessionId", session.getId());
        return "session";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Successfully logged out.";
    }
}
