package com.example;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/me")
    public String user(OAuth2Authentication principal, Model model) {
        model.addAttribute("username", principal.getName());
        model.addAttribute("details", principal.getUserAuthentication().getDetails());
        return "user";
    }
}
