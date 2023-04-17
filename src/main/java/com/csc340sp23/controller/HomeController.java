package com.csc340sp23.controller;

import com.csc340sp23.domain.Hyperlink;
import com.csc340sp23.repository.HyperlinkRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @Autowired
    private HyperlinkRepository hyperlinkRepository;

    @GetMapping("/")
    public String home(Model model) {
        System.out.println("Home method called!");
        List<Hyperlink> hyperlinks = hyperlinkRepository.findAll();
        model.addAttribute("hyperlinks", hyperlinks);
        return "home";
    }


    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("Login method called!");
        return "login";
    }

    @GetMapping("/favorites")
    public String favorites(Model model) {
        System.out.println("Favorites method called!");
        return "favorites";
    }
    
    @GetMapping("/contact")
    public String contact(Model model) {
        System.out.println("Contact method called!");
        return "contact";
    }
}
